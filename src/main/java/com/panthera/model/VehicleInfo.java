/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Administrator
 */
@Data
@Entity
public class VehicleInfo implements Serializable {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String modelName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;
    private boolean isUsedCar;
    private double price;
    
    

}
