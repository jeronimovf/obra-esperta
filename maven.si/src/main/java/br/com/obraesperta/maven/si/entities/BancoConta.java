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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "BancoConta.findAll", query = "SELECT b FROM BancoConta b"),
    @NamedQuery(name = "BancoConta.findById", query = "SELECT b FROM BancoConta b WHERE b.id = :id"),
    @NamedQuery(name = "BancoConta.findByConta", query = "SELECT b FROM BancoConta b WHERE b.conta = :conta"),
    @NamedQuery(name = "BancoConta.findByTipo", query = "SELECT b FROM BancoConta b WHERE b.tipo = :tipo"),
    @NamedQuery(name = "BancoConta.findByVariacao", query = "SELECT b FROM BancoConta b WHERE b.variacao = :variacao")})
public class BancoConta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String conta;
    @Basic(optional = false)
    @NotNull
    private int tipo;
    @Size(max = 255)
    private String variacao;
    @Basic(optional = false)
    @NotNull
    @ManyToMany(mappedBy = "contas")
    private Collection<Pessoa> titulares;
    @JoinColumn(name = "agencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BancoAgencia agencia;

    public BancoConta() {
    }

    public BancoConta(Integer id) {
        this.id = id;
    }

    public BancoConta(Integer id, String conta, int tipo, Collection<Pessoa> titulares) {
        this.id = id;
        this.conta = conta;
        this.tipo = tipo;
        this.titulares = titulares;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getVariacao() {
        return variacao;
    }

    public void setVariacao(String variacao) {
        this.variacao = variacao;
    }

    public Collection<Pessoa> getTitulares() {
        return titulares;
    }

    public void setTitulares(Collection<Pessoa> titulares) {
        this.titulares = titulares;
    }


    public BancoAgencia getAgencia() {
        return agencia;
    }

    public void setAgencia(BancoAgencia agencia) {
        this.agencia = agencia;
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
        if (!(object instanceof BancoConta)) {
            return false;
        }
        BancoConta other = (BancoConta) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getConta() + " Var: " + getVariacao();
    }
    
}
