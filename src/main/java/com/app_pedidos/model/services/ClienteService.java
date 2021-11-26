package com.app_pedidos.model.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app_pedidos.model.dto.ClienteDTO;
import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.repositories.ClienteRepository;
import com.app_pedidos.model.services.exceptions.ConstraintViolationExceptionEx;
import com.app_pedidos.model.services.exceptions.DatabaseException;
import com.app_pedidos.model.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public boolean verificaCPF(Long id){
        Cliente cliente = repository.getById(id);
        String documento = cliente.getDocumento();
        boolean verifica = false;

        for (Cliente c: repository.findAll()){
            if(documento == c.getDocumento()){
                verifica = false;
                break;
            }
            else
                verifica = true;
        }
        return verifica;
    }

    @Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setDocumento(dto.getDocumento());
		entity.setNome(dto.getNome());
		entity.setTipo(dto.getTipo());
		entity = repository.save(entity);
		
		return new ClienteDTO(entity);
	}

	public List<ClienteDTO> findAll() {
		List<Cliente> list= repository.findAll();
		List<ClienteDTO>listDto = new ArrayList<>();
		
		for(Cliente cob : list) {
			listDto.add(new ClienteDTO(cob));
		}
		
		return listDto;
	}

	public ClienteDTO findById(Long id) {
		Optional<Cliente>obj = repository.findById(id);// optional evita trabalhar com valor nulo
		Cliente entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente entity = repository.getOne(id);
			entity.setDocumento(dto.getDocumento());
			entity.setNome(dto.getNome());
			entity.setTipo(dto.getTipo());
			entity = repository.save(entity);
			return new ClienteDTO(entity);
			
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}catch(ConstraintViolationException  e) {
			throw new ConstraintViolationExceptionEx("CPF já existente");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado "+id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade do banco");
		}
		
	}

    
}
