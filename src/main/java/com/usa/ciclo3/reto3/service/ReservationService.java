package com.usa.ciclo3.reto3.service;

import com.usa.ciclo3.reto3.model.Reservation;
import com.usa.ciclo3.reto3.repository.ReservationRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepo;

    public List<Reservation> TraerTodo() {
        return reservationRepo.traerTodas();
    }

    public Reservation guardarReservacion(Reservation reservation) {
        if (Objects.isNull(reservation.getIdReservation())) {
            reservation.setStatus("created");
            return reservationRepo.guardarReservacion(reservation);
        } else {
            Optional<Reservation> reservationAux = reservationRepo.traerReservacion(reservation.getIdReservation());
            if (!reservationAux.isPresent()) {
                reservation.setStatus("created");
                return reservationRepo.guardarReservacion(reservation);

            }
        }
        return reservation;
    }
}
