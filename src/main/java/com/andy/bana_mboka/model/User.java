package com.andy.bana_mboka.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ir Andy
 */


@Entity
@NamedQuery(name="connexionByPhone",query="SELECT u FROM User u WHERE u.telephone = :telephone and u.password = :password")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private String username;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
@Column(unique = true)
   private String email;
   private String password;
   @Column(unique = true)
   private String telephone;
   @OneToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name ="adresse",referencedColumnName="id")
   private Adresse adresse;
   @OneToOne(cascade = {CascadeType.ALL})
   @JoinColumn(name ="profil",referencedColumnName="id")
   private Fichier profil;
   @OneToMany(cascade = {CascadeType.ALL})
   private List<Services> services = new ArrayList<Services>();
   @Enumerated(EnumType.STRING)
   private TypeCompte typeCompte;

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    

    public Fichier getProfil() {
        return profil;
    }

    public void setProfil(Fichier profil) {
        this.profil = profil;
    }


    public List<Services> getServices() {
        return services;
    }

    public void addService(Services e) {
        services.add(e);
    }

    public void removeServices(Services o) {
        services.remove(o);
    }

    public TypeCompte getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(TypeCompte typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
