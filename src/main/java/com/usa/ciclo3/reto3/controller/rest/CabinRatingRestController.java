/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.reto3.controller.rest;

import com.usa.ciclo3.reto3.model.CabinRating;
import com.usa.ciclo3.reto3.service.CabinRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE})
/**
 * Endpoints: Calificación de las reservas. (endpoint: /api/Score/save)
 */
public class CabinRatingRestController {
    
    @Autowired
    CabinRatingService cabinRatingService;
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CabinRating guardarCalificacion(@RequestBody CabinRating cabinRating) {
        return cabinRatingService.guardarCalificacion(cabinRating);

    }
}
