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
import com.app_pedidos.tests.factory.ProdutoFactory;

@DataJpaTest // executa o teste carregando somente os componentes do JPA, para exlcuir para deveria se ro contyroller
public class ProdutoControllerTestsJPA {

	@Autowired
	private ProdutoRepository repository;

	private long existingId;
	private long nonExistingId;
	private long countTotalProducts;

	@BeforeEach //executa antes de tudo
	void setUp() throws Exception{
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalProducts= 5l;
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
	//salvando com autoincremento
	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull(){
		Produto product = ProdutoFactory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		Optional<Produto> result = repository.findById(product.getId());
		
		//id não pode ser null
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducts+1, product.getId());//se for igual gerou o auto incremento 
		Assertions.assertTrue(result.isPresent());// testa se a busca retornou o objeto 
		Assertions.assertSame(product, result);//se a mesma referencia os objetos 
		
	}

}
