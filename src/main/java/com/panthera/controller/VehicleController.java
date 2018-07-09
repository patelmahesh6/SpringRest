/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.controller;

import com.panthera.model.VehicleInfo;
import com.panthera.service.VehicleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Administrator
 */
@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //Fetches Vehicle by id
    @GetMapping(value = "vehicle/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<VehicleInfo> getArticleById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(vehicleService.getVehicleById(id).get(), HttpStatus.OK);
    }

    //Fetches all Vehicle 
    @GetMapping(value = "vehicle", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<VehicleInfo>> getAllVehicle() {
        List<VehicleInfo> vehicleList = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    //Creates a new Vehicle
    @PostMapping(value = "vehicle", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> addArticle(@RequestBody VehicleInfo vehicleInfo, UriComponentsBuilder builder) {
        boolean flag = vehicleService.addVehicle(vehicleInfo);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/vehicle/{id}").buildAndExpand(vehicleInfo.getVehicleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Updates Vehicle
    @PutMapping(value = "vehicle", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<VehicleInfo> updateArticle(@RequestBody VehicleInfo vehicleInfo) {
        vehicleService.updateVehicle(vehicleInfo);
        return new ResponseEntity<>(vehicleInfo, HttpStatus.OK);
    }

    //Deletes Vehicle by id
    @DeleteMapping(value = "vehicle/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
