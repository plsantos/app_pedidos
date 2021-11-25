package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
