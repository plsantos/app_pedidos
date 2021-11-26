package com.app_pedidos.tests.repositories;

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
public class ClienteRepositoryTestsJPA {

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
    //deve deletar caso o id exista 
    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        repository.deleteById(existingId);

        Optional<Cliente> result = repository.findById(existingId);
        //se foi deleta 
        Assertions.assertFalse(result.isPresent());
    }
    
    //não deve deletar caso o id não exista 
    @Test
    public void deleteShouldThrowsEmptyResultDataAccessExceptionWhenIdDoesNotExists() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
    // save salva o objeto salvando o id como autoincremento
    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Cliente cliente = ClienteFactory.createCliente();
        cliente.setId(null);
        //save retorna o cliente com o id autoincremento
        cliente = repository.save(cliente);
        Optional<Cliente> result = repository.findById(cliente.getId());
        // se não é nulo o id
        Assertions.assertNotNull(cliente.getId());
        // se foi inserido e gerou um novo rgistro na quantidade de cliente 
        Assertions.assertEquals(countTotalProducts + 1L, cliente.getId());
        // tem que encontrar o id resultado do findbyid
        Assertions.assertTrue(result.isPresent());
        // se o result esta refereciando o mesmo objeto cliente
        Assertions.assertSame(result.get(), cliente);

    }
}
