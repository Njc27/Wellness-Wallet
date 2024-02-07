/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.Date;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Component;

/**
 *
 * @author namithajc
 */
@Component
@Entity
@Table
public class Medication {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private int quantity;
    private String expiryDate;
    private boolean isMorning;
    private boolean isAfternoon;
    private boolean isEvening;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public Medication() {
    }
 
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isIsMorning() {
        return isMorning;
    }

    public void setIsMorning(boolean isMorning) {
        this.isMorning = isMorning;
    }

    public boolean isIsAfternoon() {
        return isAfternoon;
    }

    public void setIsAfternoon(boolean isAfternoon) {
        this.isAfternoon = isAfternoon;
    }

    public boolean isIsEvening() {
        return isEvening;
    }

    public void setIsEvening(boolean isEvening) {
        this.isEvening = isEvening;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
