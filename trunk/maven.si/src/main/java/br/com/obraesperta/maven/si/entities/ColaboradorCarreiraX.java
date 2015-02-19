/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColaboradorCarreiraX.findAll", query = "SELECT c FROM ColaboradorCarreiraX c"),
    @NamedQuery(name = "ColaboradorCarreiraX.findById", query = "SELECT c FROM ColaboradorCarreiraX c WHERE c.id = :id"),
    @NamedQuery(name = "ColaboradorCarreiraX.findByIngressoDesde", query = "SELECT c FROM ColaboradorCarreiraX c WHERE c.ingressoDesde = :ingressoDesde"),
    @NamedQuery(name = "ColaboradorCarreiraX.findByIngressoAte", query = "SELECT c FROM ColaboradorCarreiraX c WHERE c.ingressoAte = :ingressoAte")})
public class ColaboradorCarreiraX implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingressoDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingressoAte;
    @JoinColumn(name = "carreira", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ColaboradorCarreira carreira;
    @JoinColumn(name = "colaborador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Colaborador colaborador;

    public ColaboradorCarreiraX() {
    }

    public ColaboradorCarreiraX(Integer id) {
        this.id = id;
    }

    public ColaboradorCarreiraX(Integer id, Date ingressoDesde) {
        this.id = id;
        this.ingressoDesde = ingressoDesde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIngressoDesde() {
        return ingressoDesde;
    }

    public void setIngressoDesde(Date ingressoDesde) {
        this.ingressoDesde = ingressoDesde;
    }

    public Date getIngressoAte() {
        return ingressoAte;
    }

    public void setIngressoAte(Date ingressoAte) {
        this.ingressoAte = ingressoAte;
    }

    public ColaboradorCarreira getCarreira() {
        return carreira;
    }

    public void setCarreira(ColaboradorCarreira carreira) {
        this.carreira = carreira;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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
        if (!(object instanceof ColaboradorCarreiraX)) {
            return false;
        }
        ColaboradorCarreiraX other = (ColaboradorCarreiraX) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.ColaboradorCarreiraX[ id=" + id + " ]";
    }
    
}
