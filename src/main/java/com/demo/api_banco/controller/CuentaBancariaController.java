package com.demo.api_banco.controller;

import com.demo.api_banco.model.CuentaBancaria;
import com.demo.api_banco.model.Movimiento;
import com.demo.api_banco.service.CuentaBancariaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentaBancariaController {

    /* |Inyeccion de Dependencia| */
    @Autowired
    private CuentaBancariaService cuentaServ;


    @GetMapping("/cuentas/traer")
    public List<CuentaBancaria> getCuentasBancarias(){
        return cuentaServ.getCuentasBancarias();
    }

    @PostMapping("/cuentas/crear")
    public String crearCuenta(@RequestBody CuentaBancaria cuentaB){
        cuentaServ.saveCuenta(cuentaB);
        return "Cuenta |CREADA| Correctamente!";
    }

    @DeleteMapping("/cuentas/borrar/{id}")
    public String borrarCuenta(@PathVariable Long id){
        cuentaServ.deleteCuenta(id);
        return "Cuenta |Elimnada| Correctamente!";
    }

    @GetMapping("/cuentas/traeruno/{id}")
    public CuentaBancaria findCuenta(@PathVariable Long id){
        return cuentaServ.findCuenta(id);
    }

    @PutMapping("/cuentas/edit")
    public String editCuenta(@RequestBody CuentaBancaria cuentaB){
        cuentaServ.editCuenta(cuentaB);
        return "Cuenta |Editada| Correctamente!";
    }

    @GetMapping("/cuentas/{id}/movimientos")
    public List<Movimiento> movimientosDeUnaCuenta(@PathVariable Long id){
        return cuentaServ.movimientosDeUnaCuenta(id);
    }


}
