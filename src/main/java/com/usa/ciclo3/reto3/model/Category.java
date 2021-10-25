package com.usa.ciclo3.reto3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length=45)
    private String name;

    @Column(length=250)
    private String description;

    /**
     * Relacion uno - muchos -> cabañas
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Cabana> cabins;

    // Constructores

    public Category(String name, String description, List<Cabana> cabins) {
        this.name = name;
        this.description = description;
        this.cabins = cabins;
    }
    
    public Category(){
        
    }

    // --- Getters y Setters ---
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Cabana> getCabins() {
        return cabins;
    }

    public void setCabins(List<Cabana> cabins) {
        this.cabins = cabins;
    }
}
