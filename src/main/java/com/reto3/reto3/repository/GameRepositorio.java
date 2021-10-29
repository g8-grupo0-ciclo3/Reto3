/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.repository;

import com.reto3.reto3.entity.Game;
import com.reto3.reto3.interfaces.GameRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruiz Alfonso
 */
@Repository
public class GameRepositorio {
    @Autowired
    private GameRepository crud;

    public List<Game> getAll(){
        return (List<Game>) crud.findAll();
    }

    public Optional<Game> getGame(int id){
        return crud.findById(id);
    }

    public Game save(Game game){
        return crud.save(game);
    }
    public void delete(Game game){
        crud.delete(game);
    }
}
