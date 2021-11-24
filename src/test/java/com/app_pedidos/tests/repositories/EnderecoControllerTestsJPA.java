package com.app_pedidos.tests.repositories;

import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import com.app_pedidos.tests.factory.EnderecoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class EnderecoControllerTestsJPA {

    @Autowired
    private EnderecoRepository repository;

    private long existingId;
    private long nonExsistingId;
    private long countTotalEnderecos;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExsistingId = 1000l;
        countTotalEnderecos = 4l;
    }

    @Test
    public void deleteShouldDeleteObjectWhenExists() {
        repository.deleteById(existingId);
        Optional<Endereco> result = repository.findById(existingId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowsEmptyResultDataAccessExceptionWhenIdDoesNotExists() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExsistingId);
        });
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        Endereco endereco = EnderecoFactory.createEndereco();
        endereco.setId(null);

        endereco = repository.save(endereco);
        Optional<Endereco> result = repository.findById(endereco.getId());

        Assertions.assertNotNull(endereco.getId());
        Assertions.assertEquals(countTotalEnderecos + 1L, endereco.getId());
        Assertions.assertTrue(result.isPresent());
        Assertions.assertSame(result.get(), endereco);
    }
}
