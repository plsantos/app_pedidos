package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Produto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProdutoDTO {
    private long id;
    private String descricao;
    private double valor;
    private boolean status;

    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.status = produto.isStatus();
    }

    public static List<ProdutoDTO> converter(List<Produto> produtos){
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
