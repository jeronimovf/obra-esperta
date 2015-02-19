/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @NamedQuery(name = "SolicitacaoItem.findAll", query = "SELECT s FROM SolicitacaoItem s"),
    @NamedQuery(name = "SolicitacaoItem.findById", query = "SELECT s FROM SolicitacaoItem s WHERE s.id = :id"),
    @NamedQuery(name = "SolicitacaoItem.findByAmbiente", query = "SELECT s FROM SolicitacaoItem s WHERE s.ambiente = :ambiente"),
    @NamedQuery(name = "SolicitacaoItem.findByServico", query = "SELECT s FROM SolicitacaoItem s WHERE s.servico = :servico"),
    @NamedQuery(name = "SolicitacaoItem.findByQuantidade", query = "SELECT s FROM SolicitacaoItem s WHERE s.quantidade = :quantidade"),
    @NamedQuery(name = "SolicitacaoItem.findByObservacao", query = "SELECT s FROM SolicitacaoItem s WHERE s.observacao = :observacao")})
public class SolicitacaoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 255)
    private String ambiente;
    private Integer servico;
    @Basic(optional = false)
    @NotNull
    private double quantidade;
    @Size(max = 255)
    private String observacao;
    @JoinColumn(name = "solicitacao", referencedColumnName = "id")
    @ManyToOne
    private Solicitacao solicitacao;

    public SolicitacaoItem() {
    }

    public SolicitacaoItem(Integer id) {
        this.id = id;
    }

    public SolicitacaoItem(Integer id, double quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
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
        if (!(object instanceof SolicitacaoItem)) {
            return false;
        }
        SolicitacaoItem other = (SolicitacaoItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.SolicitacaoItem[ id=" + id + " ]";
    }
    
}
