package com.demo.api_banco.service;

import com.demo.api_banco.model.CuentaBancaria;
import com.demo.api_banco.model.Movimiento;
import com.demo.api_banco.repository.IMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovimientoService implements IMovimientoService{

    @Autowired
    private IMovimientoRepository repoMovi;
    @Autowired
    private CuentaBancariaService cuentaServ;

    public List<Movimiento> getMovimientos() {
        List<Movimiento> listaMovimientos =
                repoMovi.findAll();
        return listaMovimientos;
    }

    @Override
    public void saveMovimiento(Movimiento movi) {
        depositar(movi);
        retirar(movi);
    }

    @Override
    public void deleteMovimiento(Long id) {
        repoMovi.deleteById(id);
    }

    @Override
    public Movimiento findMovimiento(Long id) {
        Movimiento movi = repoMovi.findById(id).orElse(null);
        return movi;
    }

    @Override
    public void depositar(Movimiento movi) {

        if ("Deposito".equals(movi.getTipo_movimiento())){

        Double saldoFinalDeLaCuenta = 0.0;

        CuentaBancaria cuentaB = cuentaServ.findCuenta(movi.getUnaCuenta().getId_cuenta());

            if (cuentaB.getId_cuenta() == movi.getUnaCuenta().getId_cuenta()) {
                saldoFinalDeLaCuenta = cuentaB.getSaldo() + movi.getMonto();
            }

        cuentaB.setSaldo(saldoFinalDeLaCuenta);

        repoMovi.save(movi);
        }
    }

    @Override
    public void retirar(Movimiento movi) {

        if ("Retiro".equals(movi.getTipo_movimiento())){

            Double saldoFinalDeLaCuenta = 0.0;

            CuentaBancaria cuentaB = cuentaServ.findCuenta(movi.getUnaCuenta().getId_cuenta());

            if (cuentaB.getId_cuenta() == movi.getUnaCuenta().getId_cuenta()) {
                saldoFinalDeLaCuenta = cuentaB.getSaldo() - movi.getMonto();
            }

            cuentaB.setSaldo(saldoFinalDeLaCuenta);

            repoMovi.save(movi);
        }

    }

    @Override
    public void nuevaTransferencia(Movimiento movi, Long id) {
        if ("Transferencia".equals(movi.getTipo_movimiento())){

            Double saldoFinalCuentaRemitente = 0.0;
            Double saldoFinalCuentaReceptor = 0.0;

            /*Creamos un objeto y guardamos sus datos que vienen del movimiento*/
            CuentaBancaria cuentaB = cuentaServ.findCuenta(id);

            /*Buscamos la cuenta de la id ingresada*/
            CuentaBancaria cuentaQueRecibe = cuentaServ.findCuenta(movi.getUnaCuenta().getId_cuenta());

                /*Guardamos el saldo para cada usuario en la variable local*/
                saldoFinalCuentaRemitente = cuentaB.getSaldo() - movi.getMonto();
                saldoFinalCuentaReceptor = cuentaQueRecibe.getSaldo() + movi.getMonto();


            /*Seteamos los saldos para cada usuario*/
            cuentaB.setSaldo(saldoFinalCuentaRemitente);
            cuentaQueRecibe.setSaldo(saldoFinalCuentaReceptor);
        }
        repoMovi.save(movi);

    }


}
