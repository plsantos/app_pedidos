package com.app_pedidos.model.dto;

import com.app_pedidos.model.entity.Cliente;
import com.app_pedidos.model.entity.Endereco;
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

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.cliente = pedido.getCliente();
        this.situacao = pedido.isSituacao();
    }

}
