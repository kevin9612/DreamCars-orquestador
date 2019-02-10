/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dreamcars.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kevin
 */
public class VehicleDto implements Serializable{
      
    private Long Id;
    
    private String Brand;
    
    private String model;
    
    private String version;
    
    private String year;
    
    private String numWheels;
    
    private Long numeroPlazas;
    
    private String acceleration;
    
    private Date fechaInsert;
    
    private Date fechaUpdate;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(String numWheels) {
        this.numWheels = numWheels;
    }

    public Long getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(Long numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }  
    
    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }
      
}
