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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findById", query = "SELECT s FROM Solicitacao s WHERE s.id = :id"),
    @NamedQuery(name = "Solicitacao.findByData", query = "SELECT s FROM Solicitacao s WHERE s.dataAbertura = :dataAbertura"),
    @NamedQuery(name = "Solicitacao.findByDescricao", query = "SELECT s FROM Solicitacao s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Solicitacao.findByMelhoresDiasHorariosParaRealizarServico", query = "SELECT s FROM Solicitacao s WHERE s.melhoresDiasHorariosParaRealizarServico = :melhoresDiasHorariosParaRealizarServico"),
    @NamedQuery(name = "Solicitacao.findBySolicitacaoAnterior", query = "SELECT s FROM Solicitacao s WHERE s.solicitacaoAnterior = :solicitacaoAnterior"),
    @NamedQuery(name = "Solicitacao.findBySolicitacaoPosterior", query = "SELECT s FROM Solicitacao s WHERE s.solicitacaoPosterior = :solicitacaoPosterior")})
public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAbertura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    private String descricao;
    @Size(max = 255)
    private String melhoresDiasHorariosParaRealizarServico;
    @OneToOne
    private Solicitacao solicitacaoAnterior;
    @OneToOne
    private Solicitacao solicitacaoPosterior;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "solicitacao")
    private Collection<SolicitacaoItem> solicitacaoItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitacao")
    private Collection<SolicitacaoHistorico> solicitacaoHistoricoCollection;
    @OneToMany(mappedBy = "solicitacao")
    private List<Arquivo> arquivos;
    @OneToMany(mappedBy = "solicitacao")
    private List<FluxoCaixa> fluxosCaixas;

    public Solicitacao() {
    }

    public Solicitacao(Integer id) {
        this.id = id;
    }

    public Solicitacao(Integer id, Date data, String descricao) {
        this.id = id;
        this.dataAbertura = data;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return getDataAbertura();
    }

    public void setData(Date data) {
        this.setDataAbertura(data);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMelhoresDiasHorariosParaRealizarServico() {
        return melhoresDiasHorariosParaRealizarServico;
    }

    public void setMelhoresDiasHorariosParaRealizarServico(String melhoresDiasHorariosParaRealizarServico) {
        this.melhoresDiasHorariosParaRealizarServico = melhoresDiasHorariosParaRealizarServico;
    }


    public void setSolicitacaoPosterior(Integer solicitacaoPosterior) {
        this.setSolicitacaoPosterior(solicitacaoPosterior);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Collection<SolicitacaoItem> getSolicitacaoItemCollection() {
        return solicitacaoItemCollection;
    }

    public void setSolicitacaoItemCollection(Collection<SolicitacaoItem> solicitacaoItemCollection) {
        this.solicitacaoItemCollection = solicitacaoItemCollection;
    }

    @XmlTransient
    public Collection<SolicitacaoHistorico> getSolicitacaoHistoricoCollection() {
        return solicitacaoHistoricoCollection;
    }

    public void setSolicitacaoHistoricoCollection(Collection<SolicitacaoHistorico> solicitacaoHistoricoCollection) {
        this.solicitacaoHistoricoCollection = solicitacaoHistoricoCollection;
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
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.Solicitacao[ id=" + getId() + " ]";
    }

    /**
     * @return the dataAbertura
     */
    public Date getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @param solicitacaoAnterior the solicitacaoAnterior to set
     */
    public void setSolicitacaoAnterior(Solicitacao solicitacaoAnterior) {
        this.solicitacaoAnterior = solicitacaoAnterior;
    }

    /**
     * @param solicitacaoPosterior the solicitacaoPosterior to set
     */
    public void setSolicitacaoPosterior(Solicitacao solicitacaoPosterior) {
        this.solicitacaoPosterior = solicitacaoPosterior;
    }

    /**
     * @return the arquivos
     */
    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    /**
     * @param arquivos the arquivos to set
     */
    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
    
}
