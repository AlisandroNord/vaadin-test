package com.example.application.data.service;

import com.example.application.data.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Autowired
    ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client read(int id) {
        return  clientRepository.getOne(id);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public boolean update(Client client, int id) {
        if (clientRepository.existsById(id)){
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
