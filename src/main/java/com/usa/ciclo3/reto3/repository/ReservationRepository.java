package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    ReservationCrudRepository reservationCrudRepo;

    public List<Reservation> traerTodas() {
        return (List<Reservation>) reservationCrudRepo.findAll();
    }

    public Optional<Reservation> traerReservacion(int id) {
        return reservationCrudRepo.findById(id);
    }

    public Reservation guardarReservacion(Reservation reservation) {
        return reservationCrudRepo.save(reservation);
    }
}
