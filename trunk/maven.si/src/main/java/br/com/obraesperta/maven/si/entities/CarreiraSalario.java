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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class CarreiraSalario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vigenteDesde;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vigenteAte;
    @OneToMany
    private Collection<CarreiraSalarioItem> itens;

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

    public Collection<CarreiraSalarioItem> getItens() {
        return itens;
    }

    public void setItens(Collection<CarreiraSalarioItem> itens) {
        this.itens = itens;
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
        if (!(object instanceof CarreiraSalario)) {
            return false;
        }
        CarreiraSalario other = (CarreiraSalario) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    @SuppressWarnings("empty-statement")
    public String toString() {
        return getNome() + " De: " + Singletons.getInstance().getDateFormatMedium().format(getVigenteDesde()) + " até " + 
                Singletons.getInstance().getDateFormatMedium().format(getVigenteAte());
    }
    
}
