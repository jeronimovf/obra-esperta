/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.List;
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

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u"),
    @NamedQuery(name = "Uf.findById", query = "SELECT u FROM Uf u WHERE u.id = :id"),
    @NamedQuery(name = "Uf.findByNome", query = "SELECT u FROM Uf u WHERE u.nome = :nome"),
    @NamedQuery(name = "Uf.findBySigla", query = "SELECT u FROM Uf u WHERE u.sigla = :sigla"),
    @NamedQuery(name="Uf.findItemsCompletedFromText", query = "SELECT u FROM Uf u WHERE lower(u.sigla) LIKE LOWER(:sigla) ORDER BY LOWER(u.sigla)"            )})
public class Uf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @Size(max = 255)
    private String sigla;
    @OneToMany(mappedBy = "uf")
    private List<Municipio> municipios;
    @OneToMany(mappedBy = "rgUF")
    private List<PessoaFisica> pessoaFisicas;

    public List<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }

    public void setPessoaFisicas(List<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Uf() {
    }

    public Uf(Integer id) {
        this.id = id;
    }

    public Uf(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return getSigla();
    }
    
}
