/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest.vo.exchange;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Keita Moussa
 */
@Entity
public class ProduitVo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String libelle;
    private String reference;
    private CategorieProduitVo categorieProduitVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CategorieProduitVo getCategorieProduitVo() {
        return categorieProduitVo;
    }

    public void setCategorieProduitVo(CategorieProduitVo categorieProduitVo) {
        this.categorieProduitVo = categorieProduitVo;
    }
    

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitVo)) {
            return false;
        }
        ProduitVo other = (ProduitVo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fst.tps.commandeApi.client.vo.ProduitVo[ id=" + id + " ]";
    }
    
}
