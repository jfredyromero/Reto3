package com.usa.ciclo3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ciclo3.reto3.repository.CategoryRepository;
import com.usa.ciclo3.reto3.model.Category;

import java.util.Optional;
import java.util.Objects;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    public List<Category> TraerTodo() {
        return categoryRepo.traerCategorias();
    }

    public Category guardarCategoria(Category cat) {
        if (Objects.isNull(cat.getId())) {
            return categoryRepo.gurdarCategoria(cat);
        } else {
            Optional<Category> catAux = categoryRepo.traerCategoria(cat.getId());
            if (!catAux.isPresent()) {
                return categoryRepo.gurdarCategoria(cat);
            }
            return cat;
        }
    }

}
