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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u"),
    @NamedQuery(name = "Unidade.findById", query = "SELECT u FROM Unidade u WHERE u.id = :id"),
    @NamedQuery(name = "Unidade.findByUnidade", query = "SELECT u FROM Unidade u WHERE u.unidade = :unidade"),
    @NamedQuery(name = "Unidade.findBySigla", query = "SELECT u FROM Unidade u WHERE u.sigla = :sigla"),
    @NamedQuery(name = "Unidade.findByGrandeza", query = "SELECT u FROM Unidade u WHERE u.grandeza = :grandeza"),
    @NamedQuery(name = "Unidade.findByFatorConversao", query = "SELECT u FROM Unidade u WHERE u.fatorConversao = :fatorConversao"),
    @NamedQuery(name = "Unidade.findByDestaque", query = "SELECT u FROM Unidade u WHERE u.destaque = :destaque")})
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String unidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String sigla;
    @Basic(optional = false)
    @NotNull
    private int grandeza;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double fatorConversao;
    private Short destaque;
    @OneToMany(mappedBy = "unidadeBasica")
    private Collection<Grandeza> grandezaCollection;

    public Unidade() {
    }

    public Unidade(Integer id) {
        this.id = id;
    }

    public Unidade(Integer id, String unidade, String sigla, int grandeza) {
        this.id = id;
        this.unidade = unidade;
        this.sigla = sigla;
        this.grandeza = grandeza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getGrandeza() {
        return grandeza;
    }

    public void setGrandeza(int grandeza) {
        this.grandeza = grandeza;
    }

    public Double getFatorConversao() {
        return fatorConversao;
    }

    public void setFatorConversao(Double fatorConversao) {
        this.fatorConversao = fatorConversao;
    }

    public Short getDestaque() {
        return destaque;
    }

    public void setDestaque(Short destaque) {
        this.destaque = destaque;
    }


    @XmlTransient
    public Collection<Grandeza> getGrandezaCollection() {
        return grandezaCollection;
    }

    public void setGrandezaCollection(Collection<Grandeza> grandezaCollection) {
        this.grandezaCollection = grandezaCollection;
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
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getSigla() + " (" + getGrandeza() + ")";
    }
    
}
