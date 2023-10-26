package com.demo.api_banco.service;

import ch.qos.logback.core.net.server.Client;
import com.demo.api_banco.model.Cliente;

import java.util.List;

public interface IClienteService {

    /*Traer Todos*/
    public List<Cliente> getClientes();

    /*Crear*/
    public void saveCliente(Cliente client);

    /*Eliminar*/
    public void deleteCliente(Long id);

    /*Buscar uno*/
    public Cliente findCliente(Long id);

    /*Editar/Modificar*/
    public void editCliente(Cliente client);

}
