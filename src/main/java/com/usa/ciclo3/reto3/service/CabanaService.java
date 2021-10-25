package com.usa.ciclo3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.repository.CabanaRepository;
import com.usa.ciclo3.reto3.model.Cabana;

import java.util.Optional;
import java.util.Objects;
import java.util.List;

@Service
public class CabanaService {
    @Autowired
    CabanaRepository cabinRepo;

    public List<Cabana> traerTodo() {
        return cabinRepo.traerCabanas();
    }

    public Cabana guardarCabana(Cabana cabin) {
        if (Objects.isNull(cabin.getId())) {
            return cabinRepo.guardarCabana(cabin);
        } else {
            Optional<Cabana> cabinAux = cabinRepo.traerCabana(cabin.getId());
            if (!cabinAux.isPresent()) {
                return cabinRepo.guardarCabana(cabin);
            }
            return cabin;
        }
    }

}
