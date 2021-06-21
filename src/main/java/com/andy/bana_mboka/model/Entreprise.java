
package com.andy.bana_mboka.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author admin
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Entreprise extends User{

private String numeroRCCM;
private String nom;
private Integer nombresEmployes;
private Secteur secteur_activites;
private String siteWeb;
private String description;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
