/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.obraesperta.maven.si.singletons.Singletons;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Campanha.findAll", query = "SELECT c FROM Campanha c"),
    @NamedQuery(name = "Campanha.findById", query = "SELECT c FROM Campanha c WHERE c.id = :id"),
    @NamedQuery(name = "Campanha.findByNome", query = "SELECT c FROM Campanha c WHERE c.nome = :nome"),
    @NamedQuery(name = "Campanha.findByVigenteDesde", query = "SELECT c FROM Campanha c WHERE c.vigenteDesde = :vigenteDesde"),
    @NamedQuery(name = "Campanha.findByVigenteAte", query = "SELECT c FROM Campanha c WHERE c.vigenteAte = :vigenteAte")})
public class Campanha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenteDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vigenteAte;
    @ManyToMany
    private Collection<CampanhaMidia> midias;

    public Campanha() {
    }

    public Campanha(Integer id) {
        this.id = id;
    }

    public Campanha(Integer id, String nome, Date vigenteDesde) {
        this.id = id;
        this.nome = nome;
        this.vigenteDesde = vigenteDesde;
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

    public Date getVigenteDesde() {
        return vigenteDesde;
    }

    public void setVigenteDesde(Date vigenteDesde) {
        this.vigenteDesde = vigenteDesde;
    }

    public Date getVigenteAte() {
        return vigenteAte;
    }

    public void setVigenteAte(Date vigenteAte) {
        this.vigenteAte = vigenteAte;
    }

    @XmlTransient
    public Collection<CampanhaMidia> getMidias() {
        return midias;
    }

    public void setCampanhaMidiaXCollection(Collection<CampanhaMidia> midias) {
        this.midias = midias;
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
        if (!(object instanceof Campanha)) {
            return false;
        }
        Campanha other = (Campanha) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNome() + " De: " + Singletons.getInstance().getDateFormatMedium().format(getVigenteDesde()) + " até " + 
                Singletons.getInstance().getDateFormatMedium().format(getVigenteAte());
    }
    
}
