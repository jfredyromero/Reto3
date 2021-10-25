package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.repository.crud.CategoryCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.usa.ciclo3.reto3.model.Category;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    CategoryCrudRepository categoryCrudRepo;

    public List<Category> traerCategorias(){
        return (List<Category>) categoryCrudRepo.findAll();
    }
        
    public Optional <Category> traerCategoria(int id){
        return categoryCrudRepo.findById(id);
    }

    public Category gurdarCategoria(Category cat){
        return categoryCrudRepo.save(cat);
    }
}
