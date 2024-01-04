package com.demo.api_banco.service;

import ch.qos.logback.core.net.server.Client;
import com.demo.api_banco.model.Cliente;
import com.demo.api_banco.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    /*Inyeccion de Dependencia*/
    @Autowired
    private IClienteRepository repoClient;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = repoClient.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente client) {
        repoClient.save(client);
    }

    @Override
    public void deleteCliente(Long id) {
        repoClient.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente client = repoClient.findById(id).orElse(null);
        return client;
    }

    @Override
    public void editCliente(Cliente client) {
        this.saveCliente(client);
    }
}
