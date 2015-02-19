/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampanhaMidia.findAll", query = "SELECT c FROM CampanhaMidia c"),
    @NamedQuery(name = "CampanhaMidia.findById", query = "SELECT c FROM CampanhaMidia c WHERE c.id = :id"),
    @NamedQuery(name = "CampanhaMidia.findByNome", query = "SELECT c FROM CampanhaMidia c WHERE c.nome = :nome")})
public class CampanhaMidia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @ManyToMany(mappedBy = "midias")
    private Collection<Campanha> campanhas;

    public CampanhaMidia() {
    }

    public CampanhaMidia(Integer id) {
        this.id = id;
    }

    public CampanhaMidia(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Campanha> getCampanhas() {
        return campanhas;
    }

    public void setCampanhas(Collection<Campanha> campanhas) {
        this.campanhas = campanhas;
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
        if (!(object instanceof CampanhaMidia)) {
            return false;
        }
        CampanhaMidia other = (CampanhaMidia) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
