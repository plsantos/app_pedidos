package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Produto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProdutoDTO {
    private String descricao;
    private double valor_unitario;

    public ProdutoDTO(Produto produto){
        this.descricao = produto.getDescricao();
        this.valor_unitario = produto.getValor_unitario();
    }

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
