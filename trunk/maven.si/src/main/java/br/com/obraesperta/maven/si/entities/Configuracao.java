/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.obraesperta.maven.si.singletons.Singletons;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracao.findAll", query = "SELECT c FROM Configuracao c"),
    @NamedQuery(name = "Configuracao.findById", query = "SELECT c FROM Configuracao c WHERE c.id = :id"),
    @NamedQuery(name = "Configuracao.findByChave", query = "SELECT c FROM Configuracao c WHERE c.chave = :chave"),
    @NamedQuery(name = "Configuracao.findByValor", query = "SELECT c FROM Configuracao c WHERE c.valor = :valor"),
    @NamedQuery(name = "Configuracao.findByAtivoDesde", query = "SELECT c FROM Configuracao c WHERE c.ativoDesde = :ativoDesde"),
    @NamedQuery(name = "Configuracao.findByAtivoAte", query = "SELECT c FROM Configuracao c WHERE c.ativoAte = :ativoAte")})
public class Configuracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String chave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoAte;

    public Configuracao() {
    }

    public Configuracao(Integer id) {
        this.id = id;
    }

    public Configuracao(Integer id, String chave, String valor, Date ativoDesde) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
        this.ativoDesde = ativoDesde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getAtivoDesde() {
        return ativoDesde;
    }

    public void setAtivoDesde(Date ativoDesde) {
        this.ativoDesde = ativoDesde;
    }

    public Date getAtivoAte() {
        return ativoAte;
    }

    public void setAtivoAte(Date ativoAte) {
        this.ativoAte = ativoAte;
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
        if (!(object instanceof Configuracao)) {
            return false;
        }
        Configuracao other = (Configuracao) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getChave() + " = " + getValor() + " De: " + Singletons.getInstance().getDateFormatMedium().format(getAtivoDesde()) + " até " + 
                Singletons.getInstance().getDateFormatMedium().format(getAtivoAte());
    }
    
}
