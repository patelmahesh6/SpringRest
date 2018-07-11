/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.ApiConsumer;

import com.panthera.model.VehicleInfo;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Administrator
 */
public class VehicleConsumer {

    public static final String REST_SERVICE_URI = "http://localhost:8080/api/";

    /* GET */
    @SuppressWarnings("unchecked")
    private void listAllVehicleInfos() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> vehicleMap = restTemplate.getForObject(REST_SERVICE_URI + "/vehicle/", List.class);

        if (vehicleMap != null) {
            for (LinkedHashMap<String, Object> map : vehicleMap) {
                System.out.println("VehicleInfo : id=" + map.get("vehicleId") + ", Name=" + map.get("modelName"));;
            }
        } else {
        }
    }

    /* GET */
    private void getVehicleInfo() {
        RestTemplate restTemplate = new RestTemplate();
        VehicleInfo vehicle = restTemplate.getForObject(REST_SERVICE_URI + "/vehicle/1", VehicleInfo.class);
        System.out.println(vehicle);
    }

    /* POST */
    private void createVehicleInfo() {
        RestTemplate restTemplate = new RestTemplate();
        VehicleInfo vehicle = new VehicleInfo();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/vehicle/", vehicle, VehicleInfo.class);

    }

    /* PUT */
    private void updateVehicleInfo() {

        RestTemplate restTemplate = new RestTemplate();
        VehicleInfo vehicle = new VehicleInfo();
        restTemplate.put(REST_SERVICE_URI + "/vehicle/1", vehicle);
        System.out.println(vehicle);
    }

    /* DELETE */
    private void deleteVehicleInfo() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/vehicle/3");

    }
}
