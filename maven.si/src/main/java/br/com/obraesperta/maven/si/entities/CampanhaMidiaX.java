/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "CampanhaMidiaX.findAll", query = "SELECT c FROM CampanhaMidiaX c"),
    @NamedQuery(name = "CampanhaMidiaX.findById", query = "SELECT c FROM CampanhaMidiaX c WHERE c.id = :id"),
    @NamedQuery(name = "CampanhaMidiaX.findByFornecedor", query = "SELECT c FROM CampanhaMidiaX c WHERE c.fornecedor = :fornecedor"),
    @NamedQuery(name = "CampanhaMidiaX.findByTiragemOuVeiculacao", query = "SELECT c FROM CampanhaMidiaX c WHERE c.tiragemOuVeiculacao = :tiragemOuVeiculacao")})
public class CampanhaMidiaX implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String fornecedor;
    @Size(max = 255)
    private String tiragemOuVeiculacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conheceuPor")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "midia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CampanhaMidia midia;
    @JoinColumn(name = "campanha", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Campanha campanha;

    public CampanhaMidiaX() {
    }

    public CampanhaMidiaX(Integer id) {
        this.id = id;
    }

    public CampanhaMidiaX(Integer id, String fornecedor) {
        this.id = id;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getTiragemOuVeiculacao() {
        return tiragemOuVeiculacao;
    }

    public void setTiragemOuVeiculacao(String tiragemOuVeiculacao) {
        this.tiragemOuVeiculacao = tiragemOuVeiculacao;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public CampanhaMidia getMidia() {
        return midia;
    }

    public void setMidia(CampanhaMidia midia) {
        this.midia = midia;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
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
        if (!(object instanceof CampanhaMidiaX)) {
            return false;
        }
        CampanhaMidiaX other = (CampanhaMidiaX) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.CampanhaMidiaX[ id=" + id + " ]";
    }
    
}
