/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.repository;

import com.reto3.reto3.entity.Reservation;
import com.reto3.reto3.interfaces.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruiz Alfonso
 */
@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationRepository crud;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
}
