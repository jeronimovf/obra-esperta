/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.caelum.stella.bean.validation.CNPJ;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@DiscriminatorValue("PJ")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p"),
    @NamedQuery(name = "PessoaJuridica.findById", query = "SELECT p FROM PessoaJuridica p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj"),
    @NamedQuery(name = "PessoaJuridica.findByInscricaoEstadualNumero", query = "SELECT p FROM PessoaJuridica p WHERE p.inscricaoEstadualNumero = :inscricaoEstadualNumero"),
    @NamedQuery(name = "PessoaJuridica.findByRazaoSocial", query = "SELECT p FROM PessoaJuridica p WHERE p.razaoSocial = :razaoSocial"),    
    @NamedQuery(name = "PessoaJuridica.findByNomeFantasia", query = "SELECT p FROM PessoaJuridica p WHERE p.nomeFantasia = :nomeFantasia"),    
    @NamedQuery(name = "PessoaJuridica.findItemsCompletedFromText", query = "SELECT p FROM PessoaJuridica p WHERE LOWER(p.nomeFantasia) LIKE lower(:nomeFantasiaOuRazaoSocial) OR LOWER(p.razaoSocial) LIKE LOWER(:nomeFantasiaOuRazaoSocial) ORDER BY p.razaoSocial, p.cnpj")})
public class PessoaJuridica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @CNPJ(formatted = true)
    @NotNull
    @Size(max = 18) 
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadualNumero;
    private String inscricaoEstadualUF;
    @OneToMany
    private Collection<PessoaFisica> contatos;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadualNumero() {
        return inscricaoEstadualNumero;
    }

    public void setInscricaoEstadualNumero(String inscricaoEstadualNumero) {
        this.inscricaoEstadualNumero = inscricaoEstadualNumero;
    }

    public String getInscricaoEstadualUF() {
        return inscricaoEstadualUF;
    }

    public void setInscricaoEstadualUF(String inscricaoEstadualUF) {
        this.inscricaoEstadualUF = inscricaoEstadualUF;
    }

    public Collection<PessoaFisica> getContatos() {
        return contatos;
    }

    public void setContatos(Collection<PessoaFisica> contatos) {
        this.contatos = contatos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        return (getId() != null || other.getId() == null) && (getId() == null || getId().equals(other.getId()));
    }

    @Override
    public String toString() {
        return getRazaoSocial() + " (" + getCnpj() + ")";
    }
    
}
