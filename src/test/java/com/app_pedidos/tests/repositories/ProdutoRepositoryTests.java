package com.app_pedidos.tests.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.app_pedidos.model.entity.Produto;
import com.app_pedidos.model.repositories.ProdutoRepository;

@DataJpaTest // executa o teste carregando somente os componentes do JPA, para exlcuir para deveria se ro contyroller
public class ProdutoRepositoryTests {

	@Autowired
	private ProdutoRepository repository;

	private long existingId;
	private long nonExistingId;

	@BeforeEach //executa antes de tudo
	void setUp() throws Exception{
		existingId = 1L;
		nonExistingId = 1000L;
	}
	//deletar id se existir
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		repository.deleteById(existingId);
		
		Optional<Produto> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	//não deletar id se não existir
	@Test
	public void deleteShouldThrowsEmptyResultDataAccessExceptionWhenIdDoesNotExists() {

		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);
		});
	}

}
