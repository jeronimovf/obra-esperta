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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BancoAgencia.findAll", query = "SELECT b FROM BancoAgencia b"),
    @NamedQuery(name = "BancoAgencia.findById", query = "SELECT b FROM BancoAgencia b WHERE b.id = :id"),
    @NamedQuery(name = "BancoAgencia.findByNumero", query = "SELECT b FROM BancoAgencia b WHERE b.numero = :numero"),
    @NamedQuery(name = "BancoAgencia.findByNome", query = "SELECT b FROM BancoAgencia b WHERE b.nome = :nome")})
public class BancoAgencia extends PessoaJuridica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    private String numero;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    private String nome;
    @JoinColumn(name = "banco", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Banco banco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencia")
    private Collection<BancoConta> contas;

    public BancoAgencia() {
    }

    public BancoAgencia(Integer id) {
        this.id = id;
    }

    public BancoAgencia(Integer id, String numero, String nome) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Collection<BancoConta> getContas() {
        return contas;
    }

    public void setContas(Collection<BancoConta> contas) {
        this.contas = contas;
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
        if (!(object instanceof BancoAgencia)) {
            return false;
        }
        BancoAgencia other = (BancoAgencia) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNumero() + " (" + getNome() + ")";
    }
    
}
