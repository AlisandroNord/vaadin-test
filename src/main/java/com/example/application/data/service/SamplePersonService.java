package com.example.application.data.service;

import com.example.application.data.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class SamplePersonService extends CrudService<Client, Integer> {

    private ClientRepository repository;

    public SamplePersonService(@Autowired ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ClientRepository getRepository() {
        return repository;
    }

}
