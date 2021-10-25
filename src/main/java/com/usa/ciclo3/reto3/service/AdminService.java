package com.usa.ciclo3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.repository.AdminRepository;
import com.usa.ciclo3.reto3.model.Admin;

import java.util.Optional;
import java.util.Objects;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public List<Admin> traerTodo() {
        return adminRepo.traerAdmins();
    }

    public Admin guardarAdmin(Admin admin) {
        if (Objects.isNull(admin.getId())) {
            return adminRepo.guardarAdmin(admin);
        } else {
            Optional<Admin> adminAux = adminRepo.traerAdmin(admin.getId());
            if (!adminAux.isPresent()) {
                return adminRepo.guardarAdmin(admin);
            }
            return admin;
        }
    }
}
