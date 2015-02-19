/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "ColaboradorFuncao.findAll", query = "SELECT c FROM ColaboradorFuncao c"),
    @NamedQuery(name = "ColaboradorFuncao.findById", query = "SELECT c FROM ColaboradorFuncao c WHERE c.id = :id"),
    @NamedQuery(name = "ColaboradorFuncao.findByNome", query = "SELECT c FROM ColaboradorFuncao c WHERE c.nome = :nome"),
    @NamedQuery(name = "ColaboradorFuncao.findByDescricao", query = "SELECT c FROM ColaboradorFuncao c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "ColaboradorFuncao.findByAtivaDesde", query = "SELECT c FROM ColaboradorFuncao c WHERE c.ativaDesde = :ativaDesde"),
    @NamedQuery(name = "ColaboradorFuncao.findByAtivaAte", query = "SELECT c FROM ColaboradorFuncao c WHERE c.ativaAte = :ativaAte")})
public class ColaboradorFuncao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @Size(max = 255)
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativaDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativaAte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcao")
    private Collection<ColaboradorCarreira> colaboradorCarreiraCollection;
    @OneToMany(mappedBy = "funcao")
    private List<PlanoManutencaoItem> itens;

    public ColaboradorFuncao() {
    }

    public ColaboradorFuncao(Integer id) {
        this.id = id;
    }

    public ColaboradorFuncao(Integer id, String nome, Date ativaDesde) {
        this.id = id;
        this.nome = nome;
        this.ativaDesde = ativaDesde;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getAtivaDesde() {
        return ativaDesde;
    }

    public void setAtivaDesde(Date ativaDesde) {
        this.ativaDesde = ativaDesde;
    }

    public Date getAtivaAte() {
        return ativaAte;
    }

    public void setAtivaAte(Date ativaAte) {
        this.ativaAte = ativaAte;
    }

    @XmlTransient
    public Collection<ColaboradorCarreira> getColaboradorCarreiraCollection() {
        return colaboradorCarreiraCollection;
    }

    public void setColaboradorCarreiraCollection(Collection<ColaboradorCarreira> colaboradorCarreiraCollection) {
        this.colaboradorCarreiraCollection = colaboradorCarreiraCollection;
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
        if (!(object instanceof ColaboradorFuncao)) {
            return false;
        }
        ColaboradorFuncao other = (ColaboradorFuncao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.ColaboradorFuncao[ id=" + id + " ]";
    }
    
}
