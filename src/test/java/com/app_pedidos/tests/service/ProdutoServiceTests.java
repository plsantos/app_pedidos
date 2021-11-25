package com.app_pedidos.tests.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;
import com.app_pedidos.model.services.ProdutoService;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;
import com.app_pedidos.tests.factory.ProdutoFactory;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTests {

	@InjectMocks //anotaçâo para o que se deseja testar
	private ProdutoService service;
	@Mock
	private ProdutoRepository repository;
	
	private long existingId;
	private long nonExistingId;
	private long dependentId;
	@BeforeEach // executa antes de tudo
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		dependentId = 3L;

		// nao faz nada quando o metodo é chamado com um id existente
		Mockito.doNothing().when(repository).deleteById(existingId);
		
		// lanca uma excecao se o id não existe para deletar *
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
		
		// lanca uma excecao se o id estiver sendo referenciado em outra tabela para
		Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
	}
	// se passar o nonExistingId tem que da erro pq o comportamento simulado diz para dar excecao *
	@Test
	public void deleteShouldDoNothingWhenIdExists() {
		Assertions.assertDoesNotThrow(() -> {
			service.delete(existingId);
		});
		// verifica se o metodo deleteById foi chamado no ProdutoRepository um unica vez
		Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
	}
	
	// se o id não existe deve lançar uma excecão
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdExists() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {// lança exceção quando é passado um id invalido
																		// pra deletar
			service.delete(nonExistingId);
		});
		// verifica se o metodo deleteById foi chamado no ProdutoRepository um unica vez
		Mockito.verify(repository, Mockito.times(1)).deleteById(nonExistingId);
	}
	
	// se o id for referenciado em outra tabela lançar uma excecão
	@Test
	public void deleteShouldThrowEmptyDatabaseExceptionWhenIdDoesNotExists() {
		Assertions.assertThrows(DatabaseException.class, () -> {
			service.delete(dependentId);
		});
		// verifica se o metodo deleteById foi chamado no ProdutoRepository um unica vez
		Mockito.verify(repository, Mockito.times(1)).deleteById(dependentId);
	}

	// se salvar com id nulo não lança excecao
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

		Assertions.assertDoesNotThrow(() -> {// não lança exceção
			Produto produto = ProdutoFactory.createProduct();
			produto.setId(null);
			produto = repository.save(produto);

		});
		// verifica se o método de salvamento foi invocado
		Mockito.verify(repository).save(Mockito.any(Produto.class));
	}
}
