package com.demo.api_banco.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cuenta;
    private Long cbu;
    private Double saldo;
    @OneToOne
    private Cliente unCliente;


    public CuentaBancaria() {
    }

    public CuentaBancaria(Long id_cuenta, Long cbu, Double saldo, Cliente unCliente) {
        this.id_cuenta = id_cuenta;
        this.cbu = cbu;
        this.saldo = saldo;
        this.unCliente = unCliente;
    }

}
