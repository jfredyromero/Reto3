package com.usa.ciclo3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.Admin;
import com.usa.ciclo3.reto3.repository.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepo;

    public List<Admin> traerAdmins(){
        return (List<Admin>) adminCrudRepo.findAll();
    }

    public Optional<Admin> traerAdmin(int id) {
        return adminCrudRepo.findById(id);
    }

    public Admin guardarAdmin(Admin admin) {
        return adminCrudRepo.save(admin);
    }

}
