package com.demo.api_banco.service;

import com.demo.api_banco.model.CuentaBancaria;
import com.demo.api_banco.model.Movimiento;

import java.util.List;

public interface IMovimientoService {


    /*Traer Todos*/
    public List<Movimiento> getMovimientos();

    /*Crear*/
    public void saveMovimiento(Movimiento movi);

    /*Eliminar*/
    public void deleteMovimiento(Long id);

    /*Buscar uno*/
    public Movimiento findMovimiento(Long id);

    /*Depositar*/
    public void depositar(Movimiento movi);

    /*Retirar*/
    public void retirar(Movimiento movi);

    /*Transferir*/
    public void nuevaTransferencia(Movimiento movi, Long id);

}
