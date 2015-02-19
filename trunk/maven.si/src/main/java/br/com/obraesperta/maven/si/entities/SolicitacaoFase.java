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
    @NamedQuery(name = "SolicitacaoFase.findAll", query = "SELECT s FROM SolicitacaoFase s"),
    @NamedQuery(name = "SolicitacaoFase.findById", query = "SELECT s FROM SolicitacaoFase s WHERE s.id = :id"),
    @NamedQuery(name = "SolicitacaoFase.findByFase", query = "SELECT s FROM SolicitacaoFase s WHERE s.fase = :fase")})
public class SolicitacaoFase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String fase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fase")
    private Collection<SolicitacaoHistorico> solicitacaoHistoricoCollection;

    public SolicitacaoFase() {
    }

    public SolicitacaoFase(Integer id) {
        this.id = id;
    }

    public SolicitacaoFase(Integer id, String fase) {
        this.id = id;
        this.fase = fase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    @XmlTransient
    public Collection<SolicitacaoHistorico> getSolicitacaoHistoricoCollection() {
        return solicitacaoHistoricoCollection;
    }

    public void setSolicitacaoHistoricoCollection(Collection<SolicitacaoHistorico> solicitacaoHistoricoCollection) {
        this.solicitacaoHistoricoCollection = solicitacaoHistoricoCollection;
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
        if (!(object instanceof SolicitacaoFase)) {
            return false;
        }
        SolicitacaoFase other = (SolicitacaoFase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.SolicitacaoFase[ id=" + id + " ]";
    }
    
}
