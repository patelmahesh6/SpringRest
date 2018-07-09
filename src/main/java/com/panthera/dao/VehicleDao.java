/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.dao;

import com.panthera.model.VehicleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrator
 */
public interface VehicleDao extends JpaRepository<VehicleInfo, Long> {
}
