package com.app_pedidos.tests.repositories;

import com.app_pedidos.model.entity.Pedido;
import com.app_pedidos.model.repositories.PedidoRepository;
import com.app_pedidos.tests.factory.PedidoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class PedidoControllerTestsJPA {

    @Autowired
    private PedidoRepository repository;

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

        Optional<Pedido> result = repository.findById(existingId);

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
        Pedido pedido = PedidoFactory.createPedido();
        pedido.setId(null);

        pedido = repository.save(pedido);
        Optional<Pedido> result = repository.findById(pedido.getId());

        Assertions.assertNotNull(pedido.getId());
        Assertions.assertEquals(countTotalProducts + 1L, pedido.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), pedido);
    }

}
