/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.interfaces;

import com.reto3.reto3.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ruiz Alfonso
 */
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
    
}
