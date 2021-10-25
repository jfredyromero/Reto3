package com.usa.ciclo3.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.usa.ciclo3.reto3.model.Reservation;

@Repository
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

}
