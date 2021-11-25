package com.app_pedidos.tests.repositories;

import com.app_pedidos.controller.EnderecoController;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;
import com.app_pedidos.tests.factory.EnderecoFactory;
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

@ExtendWith(SpringExtension.class)
public class EnderecoControllerTestsMockito {

    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private long nondependentId;

    @InjectMocks
    private EnderecoController controller;

    @Mock
    private EnderecoRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        dependentId = 1L;
        nondependentId = 5L;

        Mockito.doNothing().when(repository).deleteById(existingId);

        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);

        Mockito.doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            controller.delete(existingId);
        });

        Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            controller.delete(nonExistingId);
        });
        Mockito.verify(repository, Mockito.times(1)).deleteById(nonExistingId);
    }

    @Test
    public void deleteShouldThrowEmptyDatabaseExceptionWhenIdExists() {
        Assertions.assertThrows(DatabaseException.class, () -> {
            controller.delete(dependentId);
        });
        Mockito.verify(repository, Mockito.times(1)).deleteById(dependentId);
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

        Assertions.assertDoesNotThrow(() -> {
            Endereco endereco = EnderecoFactory.createEndereco();
            endereco.setId(null);
            endereco = repository.save(endereco);

        });
        Mockito.verify(repository).save(Mockito.any(Endereco.class));
    }
}
