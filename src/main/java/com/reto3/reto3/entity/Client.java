/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Ruiz Alfonso
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
public class Client implements Serializable {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Reservation>reservations;
}
