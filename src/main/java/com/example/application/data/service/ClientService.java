package com.example.application.data.service;

import com.example.application.data.entity.Client;

import java.util.List;

public interface ClientService {
    void create(Client client);
    Client read(int id);
    List<Client> readAll();
    boolean update (Client client, int id);
    boolean delete (int id);
}
