/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.service;

import com.panthera.dao.VehicleDao;
import com.panthera.model.VehicleInfo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    public void deleteVehicle(Integer id) {
        vehicleDao.deleteById(new Long(String.valueOf(id)));
    }

    public void updateVehicle(VehicleInfo vehicleInfo) {
        
    }

    public Optional<VehicleInfo> getVehicleById(Integer id) {
        return vehicleDao.findById(new Long(String.valueOf(id)));
    }

    public List<VehicleInfo> getAllVehicles() {
        return vehicleDao.findAll();
    }

    public boolean addVehicle(VehicleInfo vehicleInfo) {
        return vehicleDao.save(vehicleInfo) == null;
    }

}
