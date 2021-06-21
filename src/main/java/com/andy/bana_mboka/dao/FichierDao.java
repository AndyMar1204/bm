package com.andy.bana_mboka.dao;

import com.andy.bana_mboka.model.Fichier;
import org.hibernate.Session;

/**
 *
 * @author Ir Andy
 */


public class FichierDao extends GenericDAO<Fichier,Long>{

    public FichierDao(Session session) {
        super(session, Fichier.class);
    }

  
    
}
