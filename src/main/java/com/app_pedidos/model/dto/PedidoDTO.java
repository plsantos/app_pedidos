package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private LocalDate data;
    private Cliente cliente;
    private boolean situacao;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private double valorTotal;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.cliente = pedido.getCliente();
        this.situacao = pedido.isSituacao();
        this.rua = pedido.getRua();
        this.numero = pedido.getNumero();
        this.bairro = pedido.getBairro();
        this.cidade = pedido.getCidade();
        this.bairro = pedido.getBairro();
        this.estado = pedido.getEstado();
        this.cep = pedido.getCep();
        this.valorTotal = pedido.getValorTotal();
    }

}
