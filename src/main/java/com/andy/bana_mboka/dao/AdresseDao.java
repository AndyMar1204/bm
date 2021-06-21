/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andy.bana_mboka.dao;

import com.andy.bana_mboka.model.Adresse;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class AdresseDao extends GenericDAO<Adresse,Long>{
    
    public AdresseDao(Session session) {
        super(session, Adresse.class);
    }
    
}
