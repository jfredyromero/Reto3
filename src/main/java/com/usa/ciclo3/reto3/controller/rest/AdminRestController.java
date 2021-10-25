package com.usa.ciclo3.reto3.controller.rest;

import com.usa.ciclo3.reto3.model.Admin;
import com.usa.ciclo3.reto3.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * (endpoint: /api/Admin/save)
 * (endpoint: /api/Admin/all)
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class AdminRestController {

    @Autowired
    AdminService adminService;

    @GetMapping("/all")
    public List<Admin> traerAdmins(){
        return adminService.traerTodo();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin guardarCliente(@RequestBody Admin admin) {
        return adminService.guardarAdmin(admin);
    }

}
