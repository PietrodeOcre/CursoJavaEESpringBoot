/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nklbs.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pietrodeocre
 */
public class EncriptarPassword {
    
    public static void main(String[] args) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String password = "1234";
        System.out.println("Password sin encrypt: " + password);
        System.out.println("Password sin encrypt: " + encriptarPassword(password));
        
    }
    
    public static String encriptarPassword(String password){
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(password);
        
    }
    
}
