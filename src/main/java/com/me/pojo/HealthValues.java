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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.Date;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author namithajc
 */
@Component
@Entity
@Table(name = "healthValues")
public class HealthValues {
    @Id
    @GeneratedValue
    private int healthId;
    
    @Column(name="bloodPressure")
    private String bloodPressure;
    
    @Column(name="bloodSugar")
    private String bloodSugar;
    
    @Column(name="totalCholestrol")
    private String totalCholestrol;
    
    @Column(name="bmi")
    private String bmi;
    
    
    @Column(name="datetime")
    private String datetime;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public int getHealthId() {
        return healthId;
    }

    public void setHealthId(int healthId) {
        this.healthId = healthId;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(String bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public String getTotalCholestrol() {
        return totalCholestrol;
    }

    public void setTotalCholestrol(String totalCholestrol) {
        this.totalCholestrol = totalCholestrol;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getDatetime() {
        return datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    
    
    
}
