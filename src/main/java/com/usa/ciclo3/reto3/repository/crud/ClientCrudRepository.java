package com.usa.ciclo3.reto3.repository.crud;

import com.usa.ciclo3.reto3.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCrudRepository extends CrudRepository <Client,Integer> {
    
}
