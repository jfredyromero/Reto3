package com.usa.ciclo3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Client;
import com.usa.ciclo3.reto3.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {


    @Autowired
    private ClientCrudRepository clienteCrudRepo;

    public List<Client> traerClientes(){
        return (List<Client>) clienteCrudRepo.findAll();
    }

    public Optional<Client> traerCliente(int id) {
        return clienteCrudRepo.findById(id);
    }

    public Client guardarCliente(Client client) {
        return clienteCrudRepo.save(client);
    }
}
