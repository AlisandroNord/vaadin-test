package com.example.application.data.service;

import com.example.application.data.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import java.util.List;

@Service
public class ClientService extends CrudService<Client, Integer> {

    private ClientRepository clientRepository;

    @Autowired
    ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    protected JpaRepository<Client, Integer> getRepository() {
        return clientRepository;
    }
}
