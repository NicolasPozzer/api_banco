package com.demo.api_banco.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_movimiento;
    private LocalDate fecha;
    private Double monto;
    private String tipo_movimiento;
    @ManyToOne
    private CuentaBancaria unaCuenta;


    public Movimiento() {
    }

    public Movimiento(Long id_movimiento, LocalDate fecha, Double monto, String tipo_movimiento, CuentaBancaria unaCuenta) {
        this.id_movimiento = id_movimiento;
        this.fecha = fecha;
        this.monto = monto;
        this.tipo_movimiento = tipo_movimiento;
        this.unaCuenta = unaCuenta;
    }
}
