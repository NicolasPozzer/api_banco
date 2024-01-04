package com.demo.api_banco.controller;

import com.demo.api_banco.model.Movimiento;
import com.demo.api_banco.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoController {

    /* |Inyeccion de Dependencia del Servicio de Movimiento| */
    @Autowired
    private MovimientoService moviServ;

    @GetMapping("/movimientos/traer")
    public List<Movimiento> getMovimientos(){
        return moviServ.getMovimientos();
    }

    @PostMapping("/movimientos/crear")
    public String crearMovimiento(@RequestBody Movimiento movi){
        moviServ.saveMovimiento(movi);
        return "El Movimiento Fue |Creado| Correctamente!";
    }

    @DeleteMapping("/movimientos/borrar/{id}")
    public String deleteMovimiento(@PathVariable Long id){
        moviServ.deleteMovimiento(id);
        return "El movimiento fue |ELIMINADO| Correctamente!";
    }


    @GetMapping("/movimientos/traeruno/{id}")
    public Movimiento findMovimiento(@PathVariable Long id){
        return moviServ.findMovimiento(id);
    }

    @PostMapping("/movimientos/transferir/{id}")
    public String nuevaTransferencia(@RequestBody Movimiento movi, @PathVariable Long id){
        moviServ.nuevaTransferencia(movi, id);
        return "La Transferencia fue |ENVIADA| Correctamente!";
    }

}







