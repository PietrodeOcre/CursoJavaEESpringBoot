/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nklbs.dao;

import com.nklbs.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pietrodeocre
 */
public interface PersonaDao extends JpaRepository<Persona, Long>{
    
    
    
}
