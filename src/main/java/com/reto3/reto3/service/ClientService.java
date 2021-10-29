/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.service;

import com.reto3.reto3.entity.Client;
import com.reto3.reto3.repository.ClientRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruiz Alfonso
 */
@Service
public class ClientService {
    @Autowired
     private ClientRepositorio mcrud;
     
     public List<Client> getAll(){
        return mcrud.getAll();
    }
     
      public Optional<Client> getClient(int clientId) {
        return mcrud.getClient(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return mcrud.save(client);
        }else{
            Optional<Client> exp= mcrud.getClient(client.getIdClient());
            if(exp.isEmpty()){
                return mcrud.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> exp= mcrud.getClient(client.getIdClient());
            if(!exp.isEmpty()){
                if(client.getName()!=null){
                    exp.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    exp.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    exp.get().setPassword(client.getPassword());
                }
                mcrud.save(exp.get());
                return exp.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            mcrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
