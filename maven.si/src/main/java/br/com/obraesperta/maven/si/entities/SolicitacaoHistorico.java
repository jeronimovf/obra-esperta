/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

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
    @NamedQuery(name = "SolicitacaoHistorico.findAll", query = "SELECT s FROM SolicitacaoHistorico s"),
    @NamedQuery(name = "SolicitacaoHistorico.findById", query = "SELECT s FROM SolicitacaoHistorico s WHERE s.id = :id"),
    @NamedQuery(name = "SolicitacaoHistorico.findByDataHora", query = "SELECT s FROM SolicitacaoHistorico s WHERE s.dataHora = :dataHora"),
    @NamedQuery(name = "SolicitacaoHistorico.findByObservacao", query = "SELECT s FROM SolicitacaoHistorico s WHERE s.observacao = :observacao")})
public class SolicitacaoHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Size(max = 255)
    private String observacao;
    @JoinColumn(name = "fase", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SolicitacaoFase fase;
    @JoinColumn(name = "solicitacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitacao solicitacao;
    @JoinColumn(name = "responsavel", referencedColumnName = "id")
    @ManyToOne
    private Colaborador responsavel;

    public SolicitacaoHistorico() {
    }

    public SolicitacaoHistorico(Integer id) {
        this.id = id;
    }

    public SolicitacaoHistorico(Integer id, Date dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public SolicitacaoFase getFase() {
        return fase;
    }

    public void setFase(SolicitacaoFase fase) {
        this.fase = fase;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Colaborador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Colaborador responsavel) {
        this.responsavel = responsavel;
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
        if (!(object instanceof SolicitacaoHistorico)) {
            return false;
        }
        SolicitacaoHistorico other = (SolicitacaoHistorico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.SolicitacaoHistorico[ id=" + id + " ]";
    }
    
}
