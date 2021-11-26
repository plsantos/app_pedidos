package com.app_pedidos.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDate data = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private boolean situacao = true;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    @JoinColumn(nullable = true)
    private String estado;
    private String cep;
    private double valorTotal;
	   
    
    

}
