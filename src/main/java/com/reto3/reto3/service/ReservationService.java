/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.service;

import com.reto3.reto3.entity.Reservation;
import com.reto3.reto3.repository.ReservationRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruiz Alfonso
 */
@Service
public class ReservationService {
     @Autowired
    private ReservationRepositorio mcrud;

    public List<Reservation> getAll(){
        return mcrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return mcrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return mcrud.save(reservation);
        }else{
            Optional<Reservation> exp= mcrud.getReservation(reservation.getIdReservation());
            if(exp.isEmpty()){
                return mcrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> exp= mcrud.getReservation(reservation.getIdReservation());
            if(!exp.isEmpty()){

                if(reservation.getStartDate()!=null){
                    exp.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    exp.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    exp.get().setStatus(reservation.getStatus());
                }
                mcrud.save(exp.get());
                return exp.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            mcrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
