package com.demo.api_banco.service;

import com.demo.api_banco.model.CuentaBancaria;
import com.demo.api_banco.model.Movimiento;

import java.util.List;

public interface ICuentaBancariaService {

    /*Traer Todos*/
    public List<CuentaBancaria> getCuentasBancarias();

    /*Crear*/
    public void saveCuenta(CuentaBancaria cuentaB);

    /*Eliminar*/
    public void deleteCuenta(Long id);

    /*Buscar uno*/
    public CuentaBancaria findCuenta(Long id);

    /*Editar/Modificar*/
    public void editCuenta(CuentaBancaria cuentaB);

    public List<Movimiento> movimientosDeUnaCuenta(Long id);

}
