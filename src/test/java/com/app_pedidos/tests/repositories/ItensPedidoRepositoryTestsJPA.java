package com.app_pedidos.tests.repositories;

import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.repositories.ItensPedidoRepository;
import com.app_pedidos.tests.factory.ItensPedidoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ItensPedidoRepositoryTestsJPA {

    @Autowired
    private ItensPedidoRepository repository;

    private long existingId;
    private long nonExistingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalProducts = 4l;
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        repository.deleteById(existingId);

        Optional<ItensPedido> result = repository.findById(existingId);

        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowsEmptyResultDataAccessExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        ItensPedido itensPedido = ItensPedidoFactory.createItensPedido();
        itensPedido.setId(null);

        itensPedido = repository.save(itensPedido);
        Optional<ItensPedido> result = repository.findById(itensPedido.getId());

        Assertions.assertNotNull(itensPedido.getId());
        Assertions.assertEquals(countTotalProducts + 1L, itensPedido.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), itensPedido);
    }
}
