/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.obraesperta.maven.si.validators.CEP;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findById", query = "SELECT e FROM Endereco e WHERE e.id = :id"),
    @NamedQuery(name = "Endereco.findByNome", query = "SELECT e FROM Endereco e WHERE e.nome = :nome"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByMunicipio", query = "SELECT e FROM Endereco e WHERE e.municipio = :municipio"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep"),
    @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String logradouro;
    @Size(max = 255)
    private String numero;
    @Size(max = 255)
    private String edificio;
    private Integer andar;
    private Boolean possuiElevadorCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @ManyToOne
    private Municipio municipio;
    @CEP
    private String cep;
    @Size(max = 255)
    private String complemento;
    @JoinColumn(name = "pessoa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoAte;

    public Endereco() {
    }

    public Endereco(Integer id) {
        this.id = id;
    }

    public Endereco(Integer id, String nome, String logradouro, String bairro, Municipio municipio) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.municipio = municipio;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getLogradouro() + ", " + getNumero() + ", " + getBairro() + ", " + getMunicipio() + ", " + getCep();
    }

    /**
     * @return the edificio
     */
    public String getEdificio() {
        return edificio;
    }

    /**
     * @param edificio the edificio to set
     */
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    /**
     * @return the andar
     */
    public Integer getAndar() {
        return andar;
    }

    /**
     * @param andar the andar to set
     */
    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    /**
     * @return the possuiElevadorCarga
     */
    public Boolean getPossuiElevadorCarga() {
        return possuiElevadorCarga;
    }

    /**
     * @param possuiElevadorCarga the possuiElevadorCarga to set
     */
    public void setPossuiElevadorCarga(Boolean possuiElevadorCarga) {
        this.possuiElevadorCarga = possuiElevadorCarga;
    }

    /**
     * @return the ativoDesde
     */
    public Date getAtivoDesde() {
        return ativoDesde;
    }

    /**
     * @param ativoDesde the ativoDesde to set
     */
    public void setAtivoDesde(Date ativoDesde) {
        this.ativoDesde = ativoDesde;
    }

    /**
     * @return the ativoAte
     */
    public Date getAtivoAte() {
        return ativoAte;
    }

    /**
     * @param ativoAte the ativoAte to set
     */
    public void setAtivoAte(Date ativoAte) {
        this.ativoAte = ativoAte;
    }
    
}
