package com.app_pedidos.model.repositories;

import com.app_pedidos.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	

}
