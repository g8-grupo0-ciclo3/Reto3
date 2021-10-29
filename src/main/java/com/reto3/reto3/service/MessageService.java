/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.service;

import com.reto3.reto3.entity.Message;
import com.reto3.reto3.repository.MessageRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruiz Alfonso
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepositorio mcrud;

    public List<Message> getAll(){
        return mcrud.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return mcrud.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return mcrud.save(message);
        }else{
            Optional<Message> exp= mcrud.getMessage(message.getIdMessage());
            if(exp.isEmpty()){
                return mcrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> exp= mcrud.getMessage(message.getIdMessage());
            if(!exp.isEmpty()){
                if(message.getMessageText()!=null){
                    exp.get().setMessageText(message.getMessageText());
                }
                mcrud.save(exp.get());
                return exp.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            mcrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
