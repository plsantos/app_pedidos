package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.entity.ItensPedido;
import com.app_pedidos.model.entity.Pedido;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidoDTO {
    private long id;
    private LocalDate data;
    private Cliente cliente;
    private boolean situacao;
    private ItensPedido itensPedido;

    public PedidoDTO(Pedido pedido){
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.cliente = pedido.getCliente();
        this.situacao = pedido.isSituacao();
        this.itensPedido = pedido.getItensPedido();
    }

    public static List<PedidoDTO> converter(List<Pedido> pedidos){
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }
}
