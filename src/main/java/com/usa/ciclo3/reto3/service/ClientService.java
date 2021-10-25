package com.usa.ciclo3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.repository.ClientRepository;
import com.usa.ciclo3.reto3.model.Client;

import java.util.Optional;
import java.util.Objects;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepo;

    public List<Client> TraerTodo() {
        return clientRepo.traerClientes();
    }

    public Client guardarCliente(Client client) {
        if (Objects.isNull(client.getIdClient())) {
            if (client.getAge() > 0) {
                return clientRepo.guardarCliente(client);
            }
        } else {
            Optional<Client> catAux = clientRepo.traerCliente(client.getIdClient());
            if (!catAux.isPresent()) {
                if (client.getAge() > 0) {
                    return clientRepo.guardarCliente(client);
                }
            }
        }
        return client;
    }

}
