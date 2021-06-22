package com.example.application.data.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;

import com.example.application.data.service.ClientRepository;
import com.example.application.data.entity.Client;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(ClientRepository clientRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (clientRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Sample Person entities...");
            ExampleDataGenerator<Client> samplePersonRepositoryGenerator = new ExampleDataGenerator<>(
                    Client.class, LocalDateTime.of(2021, 6, 22, 0, 0, 0));
            samplePersonRepositoryGenerator.setData(Client::setId, DataType.ID);
            samplePersonRepositoryGenerator.setData(Client::setName, DataType.FULL_NAME);
            samplePersonRepositoryGenerator.setData(Client::setEmail, DataType.EMAIL);
            samplePersonRepositoryGenerator.setData(Client::setPhone, DataType.PHONE_NUMBER);
            samplePersonRepositoryGenerator.setData(Client::setDateOfBirth, DataType.DATE_OF_BIRTH);
            clientRepository.saveAll(samplePersonRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}