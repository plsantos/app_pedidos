package com.app_pedidos.tests.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.app_pedidos.controller.ProdutoController;
import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;
import com.app_pedidos.tests.factory.ProdutoFactory;

@ExtendWith(SpringExtension.class)
public class ProdutoControllerTestsMockito {
	private long existingId;
	private long nonExistingId;
		
	@InjectMocks
	private ProdutoController controller;

	@Mock
	private ProdutoRepository repository;

	@BeforeEach // executa antes de tudo
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		
		// nao faz nada quando o metodo é chamado com um id existente
		Mockito.doNothing().when(repository).deleteById(existingId);
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
	}

	@Test
	public void deleteShouldDoNothingWhenIdExists() {
		Assertions.assertDoesNotThrow(() -> {// não lança exceção quando é passado um id valido pra deletar
			controller.delete(existingId);
		});
		// verifica se o metodo deleteById foi chamado no ProdutoRepository um unica vez
		Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
	}

	// se o id não existe deve lançar uma excecão
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdExists() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {// lança exceção quando é passado um id invalido
																		// pra deletar
			controller.delete(nonExistingId);
		});
		// verifica se o metodo deleteById foi chamado no ProdutoRepository um unica vez
		Mockito.verify(repository, Mockito.times(1)).deleteById(nonExistingId);
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
