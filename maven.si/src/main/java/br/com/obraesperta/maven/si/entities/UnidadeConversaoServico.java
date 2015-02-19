/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeConversaoServico.findAll", query = "SELECT u FROM UnidadeConversaoServico u"),
    @NamedQuery(name = "UnidadeConversaoServico.findById", query = "SELECT u FROM UnidadeConversaoServico u WHERE u.id = :id"),
    @NamedQuery(name = "UnidadeConversaoServico.findByUnidade", query = "SELECT u FROM UnidadeConversaoServico u WHERE u.unidade = :unidade"),
    @NamedQuery(name = "UnidadeConversaoServico.findByOrseSERVUNIDADE", query = "SELECT u FROM UnidadeConversaoServico u WHERE u.orseSERVUNIDADE = :orseSERVUNIDADE")})
public class UnidadeConversaoServico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    private Integer unidade;
    @Size(max = 255)
    @Column(name = "orseSERV_UNIDADE")
    private String orseSERVUNIDADE;

    public UnidadeConversaoServico() {
    }

    public UnidadeConversaoServico(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public String getOrseSERVUNIDADE() {
        return orseSERVUNIDADE;
    }

    public void setOrseSERVUNIDADE(String orseSERVUNIDADE) {
        this.orseSERVUNIDADE = orseSERVUNIDADE;
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
        if (!(object instanceof UnidadeConversaoServico)) {
            return false;
        }
        UnidadeConversaoServico other = (UnidadeConversaoServico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.UnidadeConversaoServico[ id=" + id + " ]";
    }
    
}
