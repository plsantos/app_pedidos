package com.app_pedidos.tests.repositories;

import com.app_pedidos.controller.EnderecoController;
import com.app_pedidos.model.entity.Endereco;
import com.app_pedidos.model.repositories.EnderecoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EnderecoControllerTestsMockito {

    private long existingId;
    private long nonExistingId;
    @InjectMocks
    private EnderecoController controller;

    @Mock
    private EnderecoRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;

        Mockito.doNothing().when(repository).deleteById(existingId);

        Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(nonExistingId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> {
            controller.delete(existingId);
        });

        Mockito.verify(repository, Mockito.times(1)).deleteById(existingId);
    }
}
