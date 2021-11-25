package com.app_pedidos.tests.controller;

import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.repositories.ClienteRepository;
import com.app_pedidos.tests.factory.ClienteFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ClienteControllerTestsJPA {

    @Autowired
    private ClienteRepository repository;

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

        Optional<Cliente> result = repository.findById(existingId);

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
        Cliente cliente = ClienteFactory.createCliente();
        cliente.setId(null);

        cliente = repository.save(cliente);
        Optional<Cliente> result = repository.findById(cliente.getId());

        Assertions.assertNotNull(cliente.getId());
        Assertions.assertEquals(countTotalProducts + 1L, cliente.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), cliente);

    }
}
