/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workflow.findAll", query = "SELECT w FROM Workflow w"),
    @NamedQuery(name = "Workflow.findById", query = "SELECT w FROM Workflow w WHERE w.id = :id"),
    @NamedQuery(name = "Workflow.findByDocumento", query = "SELECT w FROM Workflow w WHERE w.documento = :documento"),
    @NamedQuery(name = "Workflow.findByFaseAtual", query = "SELECT w FROM Workflow w WHERE w.faseAtual = :faseAtual"),
    @NamedQuery(name = "Workflow.findByGatilho", query = "SELECT w FROM Workflow w WHERE w.gatilho = :gatilho"),
    @NamedQuery(name = "Workflow.findByFaseDestino", query = "SELECT w FROM Workflow w WHERE w.faseDestino = :faseDestino")})
public class Workflow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private int documento;
    private Integer faseAtual;
    private Integer gatilho;
    private Integer faseDestino;

    public Workflow() {
    }

    public Workflow(Integer id) {
        this.id = id;
    }

    public Workflow(Integer id, int documento) {
        this.id = id;
        this.documento = documento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Integer getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(Integer faseAtual) {
        this.faseAtual = faseAtual;
    }

    public Integer getGatilho() {
        return gatilho;
    }

    public void setGatilho(Integer gatilho) {
        this.gatilho = gatilho;
    }

    public Integer getFaseDestino() {
        return faseDestino;
    }

    public void setFaseDestino(Integer faseDestino) {
        this.faseDestino = faseDestino;
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
        if (!(object instanceof Workflow)) {
            return false;
        }
        Workflow other = (Workflow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.Workflow[ id=" + id + " ]";
    }
    
}
