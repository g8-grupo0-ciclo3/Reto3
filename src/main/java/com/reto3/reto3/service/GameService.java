/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.service;

import com.reto3.reto3.entity.Game;
import com.reto3.reto3.repository.GameRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruiz Alfonso
 */
@Service
public class GameService {
    @Autowired
    private GameRepositorio mcrud;

    public List<Game> getAll(){
        return mcrud.getAll();
    }

    public Optional<Game> getGame(int gameId) {
        return mcrud.getGame(gameId);
    }

    public Game save(Game game){
        if(game.getId()==null){
            return mcrud.save(game);
        }else{
            Optional<Game> exp=mcrud.getGame(game.getId());
            if(exp.isEmpty()){
                return mcrud.save(game);
            }else{
                return game;
            }
        }
    }

    public Game update(Game game){
        if(game.getId()!=null){
            Optional<Game> exp=mcrud.getGame(game.getId());
            if(!exp.isEmpty()){
                if(game.getName()!=null){
                    exp.get().setName(game.getName());
                }
                if(game.getDeveloper()!=null){
                    exp.get().setDeveloper(game.getDeveloper());
                }
                if(game.getYear()!=null){
                    exp.get().setYear(game.getYear());
                }
                if(game.getDescription()!=null){
                    exp.get().setDescription(game.getDescription());
                }
                if(game.getCategory()!=null){
                    exp.get().setCategory(game.getCategory());
                }
               mcrud.save(exp.get());
                return exp.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }


    public boolean deleteGame(int gameId) {
        Boolean aBoolean = getGame(gameId).map(game -> {
            mcrud.delete(game);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
