package com.usa.ciclo3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.repository.CabinRatingRepository;
import com.usa.ciclo3.reto3.model.CabinRating;

import java.util.Optional;
import java.util.Objects;
import java.util.List;

@Service
public class CabinRatingService {
    @Autowired
    CabinRatingRepository cabinRatingRepository;

    public List<CabinRating> TraerTodo() {
        return cabinRatingRepository.traerTodas();
    }

    public CabinRating guardarCalificacion(CabinRating rating) {
        if (Objects.isNull(rating.getId())) {
            if (verificaPuntaje(rating)) {
                return cabinRatingRepository.guardarCalificacion(rating);
            }
        } else {
            Optional<CabinRating> ratingAux = cabinRatingRepository.traerCalificacion(rating.getId());
            if (!ratingAux.isPresent()) {
                if (verificaPuntaje(rating)) {
                    return cabinRatingRepository.guardarCalificacion(rating);
                }
            }
        }
        return rating;
    }

    // verifica que la calificacion este entre 0 y 5
    private boolean verificaPuntaje(CabinRating rating) {
        return (rating.getRate() >= 0 && rating.getRate() <= 5);
    }

}
