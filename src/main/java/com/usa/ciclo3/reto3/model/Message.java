package com.usa.ciclo3.reto3.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * entidad mensajes
 */
@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;

    private String messageText;


    @ManyToOne
    @JoinColumn(name="clientCabins")
    @JsonIgnoreProperties({"reservations","messages"})
    private Cabana cabin;

    @ManyToOne
    @JoinColumn(name="clientMessages")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    // Constructores

    public Message() {}

    
    public Message(String messageText, Client client, Cabana cabin) {
        this.messageText = messageText;
        this.client = client;
        this.cabin = cabin;
    }


    // --- Getters y Setteres ---

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cabana getCabin() {
        return cabin;
    }

    public void setCabin(Cabana cabin) {
        this.cabin = cabin;
    }
    

}
