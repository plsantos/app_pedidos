package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.entity.Pedido;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidoDTO {
    private LocalDate data;
    private Cliente cliente;
    private boolean situacao;

    public PedidoDTO(Pedido pedido){
        this.data = pedido.getData();
        this.cliente = pedido.getCliente();
        this.situacao = pedido.isSituacao();
    }

    public static List<PedidoDTO> converter(List<Pedido> pedidos){
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }
}
