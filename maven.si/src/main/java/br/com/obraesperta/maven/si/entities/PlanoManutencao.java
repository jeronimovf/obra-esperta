/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity
public class PlanoManutencao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date vigenciaInicio;
    @Temporal(TemporalType.DATE)
    private Date vigenciaTermino;
    @NotNull
    @Size(min=20, max=255)
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "planoManutencao")
    private Collection<PlanoManutencaoItem> itens;    
    
      

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof PlanoManutencao)) {
            return false;
        }
        PlanoManutencao other = (PlanoManutencao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.maven.si.entities.PlanosManutencao[ id=" + id + " ]";
    }

    /**
     * @return the vigenciaInicio
     */
    public Date getVigenciaInicio() {
        return vigenciaInicio;
    }

    /**
     * @param vigenciaInicio the vigenciaInicio to set
     */
    public void setVigenciaInicio(Date vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    /**
     * @return the vigenciaTermino
     */
    public Date getVigenciaTermino() {
        return vigenciaTermino;
    }

    /**
     * @param vigenciaTermino the vigenciaTermino to set
     */
    public void setVigenciaTermino(Date vigenciaTermino) {
        this.vigenciaTermino = vigenciaTermino;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the itens
     */
    public Collection<PlanoManutencaoItem> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(Collection<PlanoManutencaoItem> itens) {
        this.itens = itens;
    }
    
}
