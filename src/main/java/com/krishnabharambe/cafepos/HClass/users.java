/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krishnabharambe.cafepos.HClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author admin
 */
@Entity
public class users {
    @Id
    @GeneratedValue
    int id;
    String username;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public users(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public users() {
    }

    @Override
    public String toString() {
        return "users{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
    
}
