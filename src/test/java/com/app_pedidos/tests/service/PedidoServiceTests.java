package com.app_pedidos.tests.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.PedidoRepository;
import com.app_pedidos.model.services.PedidoService;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;
import com.app_pedidos.tests.factory.PedidoFactory;

@ExtendWith(SpringExtension.class)
public class PedidoServiceTests {
	@InjectMocks //anotaçâo para o que se deseja testar
	private PedidoService service;
	@Mock
	private PedidoRepository repository;
	
	private long existingId;
	private long nonExistingId;
	@BeforeEach // executa antes de tudo
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;

		// nao faz nada quando o metodo é chamado com um id existente
		Mockito.doNothing().when(repository).deleteById(existingId);
		
		// lanca uma excecao se o id não existe para deletar *
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
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
	
	// se salvar com id nulo não lança excecao
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

		Assertions.assertDoesNotThrow(() -> {// não lança exceção
			Pedido pedido = PedidoFactory.createPedido();
			pedido.setId(null);
			pedido = repository.save(pedido);

		});
		// verifica se o método de salvamento foi invocado
		Mockito.verify(repository).save(Mockito.any(Pedido.class));
	}
}
