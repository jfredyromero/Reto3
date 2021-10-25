package com.usa.ciclo3.reto3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Historia de usuario 1 -Creación de Cabañas.
 */

@Entity
@Table(name = "cabins")
public class Cabana implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7302950957278953901L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;

    private int rooms;

    @Column(length = 250)
    private String description;


    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabins")
    private Category category;


    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin","client"})
    private List<Message> messages;


    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "cabin")
    @JsonIgnoreProperties("cabin")
    private List<Reservation> reservations;

    // Constructores

    /**
     * Constructor de clase
     */
    public Cabana() {
    }
    
    /**
     * contructor de clase
     * @param brand
     * @param rooms
     * @param category
     * @param name
     * @param description
     * @param messages
     * @param reservations 
     */
    public Cabana(String brand, int rooms, Category category, String name, String description, List<Message> messages,
            List<Reservation> reservations) {
        this.brand = brand;
        this.rooms = rooms;
        this.category = category;
        this.name = name;
        this.description = description;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Cabana(String brand, int rooms, String name, String description){
        this.brand = brand;
        this.rooms = rooms;
        this.name = name;
        this.description = description;
    }

    
    // --- Getters y Setters ---
    
    /**
     * @return id 
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return brand 
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return rooms
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * @param rooms 
     */
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    /**
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category 
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * @return List<reservations>
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
