package com.usa.ciclo3.reto3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.reto3.model.CabinRating;
import com.usa.ciclo3.reto3.repository.crud.CabinRatingCrudRepository;
import java.util.List;
import java.util.Optional;

@Repository
public class CabinRatingRepository {
    @Autowired
    CabinRatingCrudRepository cabinRatingCrudRepo;

    public List<CabinRating> traerTodas() {
        return (List<CabinRating>) cabinRatingCrudRepo.findAll();
    }

    public Optional<CabinRating> traerCalificacion(int id) {
        return cabinRatingCrudRepo.findById(id);
    }

    public CabinRating guardarCalificacion(CabinRating cabinRating) {
        return cabinRatingCrudRepo.save(cabinRating);
    }
}
