package com.app_pedidos.model.services;
import com.app_pedidos.model.dto.ClienteDTO;
import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    
    
}
