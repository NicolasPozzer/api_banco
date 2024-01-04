package com.demo.api_banco.controller;

import com.demo.api_banco.model.Cliente;
import com.demo.api_banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    /* |Inyeccion de Dependencia del Servicio de Cliente| */
    @Autowired
    private ClienteService clientServ;

    @GetMapping("/clientes/list")
    public List<Cliente> getClientes(){
        return clientServ.getClientes();
    }

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente client){
        clientServ.saveCliente(client);
        return "Cliente |CREADO| Correctamente!";
    }

    @DeleteMapping("/clientes/borrar/{id}")
    public String deleteCliente(@PathVariable Long id){
        clientServ.deleteCliente(id);
        return "Cliente |ELIMINADO| Correctamente!";
    }

    @GetMapping("/clientes/traeruno/{id}")
    public Cliente findCliente(@PathVariable Long id){
        return clientServ.findCliente(id);
    }

    @PutMapping("/clientes/editar")
    public String editCliente(@RequestBody Cliente client){
        clientServ.editCliente(client);
        return "Cliente |Editado| Correctamente!";
    }




}
