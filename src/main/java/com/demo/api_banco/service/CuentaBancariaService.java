package com.demo.api_banco.service;

import com.demo.api_banco.model.Cliente;
import com.demo.api_banco.model.CuentaBancaria;
import com.demo.api_banco.model.Movimiento;
import com.demo.api_banco.repository.ICuentaBancariaRepository;
import com.demo.api_banco.repository.IMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaBancariaService implements ICuentaBancariaService{

    /* |Inyeccion de Dependencia| */
    @Autowired
    private ICuentaBancariaRepository repoCuenta;

    @Autowired
    private IMovimientoRepository moviServ;

    @Override
    public List<CuentaBancaria> getCuentasBancarias() {
        List<CuentaBancaria> listaCuentasB = repoCuenta.findAll();
        return listaCuentasB;
    }

    @Override
    public void saveCuenta(CuentaBancaria cuentaB) {
        repoCuenta.save(cuentaB);
    }

    @Override
    public void deleteCuenta(Long id) {
        repoCuenta.deleteById(id);
    }

    @Override
    public CuentaBancaria findCuenta(Long id) {
        CuentaBancaria cuentaB = repoCuenta.findById(id).orElse(null);
        return cuentaB;
    }

    @Override
    public void editCuenta(CuentaBancaria cuentaB) {
        this.saveCuenta(cuentaB);
    }

    @Override
    public List<Movimiento> movimientosDeUnaCuenta(Long id) {

        List<Movimiento> lista = moviServ.findAll();
        /*Lista donde se guardara los movimientos de una |Sola Cuenta|*/
        List<Movimiento> listaMovimientos = new ArrayList<>();

        for (Movimiento movi : lista){
            if (movi.getUnaCuenta().getId_cuenta() == id){
                listaMovimientos.add(movi);
            }

        }
        return listaMovimientos;
    }


}
