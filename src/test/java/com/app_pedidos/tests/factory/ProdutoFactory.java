package com.app_pedidos.tests.factory;

import com.app_pedidos.model.dto.ProdutoDTO;
import com.app_pedidos.model.entity.Produto;

public class ProdutoFactory {
	public static Produto createProduct() {
		return  new Produto(null,"novo livro",30.50,true);
	}
	public static ProdutoDTO createProdutoDTO() {
		return new ProdutoDTO(createProduct());
	}

}
