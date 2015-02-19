/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b"),
    @NamedQuery(name = "Banco.findById", query = "SELECT b FROM Banco b WHERE b.id = :id"),
    @NamedQuery(name = "Banco.findByCodigo", query = "SELECT b FROM Banco b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "Banco.findByNome", query = "SELECT b FROM Banco b WHERE b.nome = :nome"),
    @NamedQuery(name = "Banco.findItemsCompletedFromText", query = "SELECT b FROM Banco b WHERE LOWER(b.nome) LIKE LOWER(:nome) ORDER BY b.nome"),    
    @NamedQuery(name = "Banco.findBySite", query = "SELECT b FROM Banco b WHERE b.site = :site")})
public class Banco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 255)
    private String codigo;
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    private String nome;
    @Size(max = 255)
    private String site;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "banco")
    private Collection<BancoAgencia> agencias;
    private String cnpjBase;
    @OneToMany(mappedBy = "banco")
    private List<TituloPagamento> titulosPagamentos;

    public Banco() {
    }

    public Banco(Integer id) {
        this.id = id;
    }

    public Banco(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @XmlTransient
    public Collection<BancoAgencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(Collection<BancoAgencia> agencias) {
        this.agencias = agencias;
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
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNome() + " (" + getCodigo() + ")";
    }

    /**
     * @return the cnpjBase
     */
    public String getCnpjBase() {
        return cnpjBase;
    }

    /**
     * @param cnpjBase the cnpjBase to set
     */
    public void setCnpjBase(String cnpjBase) {
        this.cnpjBase = cnpjBase;
    }
    
}
