/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.obraesperta.maven.si.interfaces.IColaborador;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findById", query = "SELECT c FROM Colaborador c WHERE c.id = :id"),
    @NamedQuery(name = "Colaborador.findBySenha", query = "SELECT c FROM Colaborador c WHERE c.senha = :senha"),
    @NamedQuery(name = "Colaborador.findByAdmissaoData", query = "SELECT c FROM Colaborador c WHERE c.admissaoData = :admissaoData"),
    @NamedQuery(name = "Colaborador.findByPisPasep", query = "SELECT c FROM Colaborador c WHERE c.pisPasep = :pisPasep"),
    @NamedQuery(name = "Colaborador.findByCtpsNumero", query = "SELECT c FROM Colaborador c WHERE c.ctpsNumero = :ctpsNumero"),
    @NamedQuery(name = "Colaborador.findByCtpsSerie", query = "SELECT c FROM Colaborador c WHERE c.ctpsSerie = :ctpsSerie"),
    @NamedQuery(name = "Colaborador.findByCtpsUF", query = "SELECT c FROM Colaborador c WHERE c.ctpsUF = :ctpsUF"),
    @NamedQuery(name = "Colaborador.findByTituloEleitorNumero", query = "SELECT c FROM Colaborador c WHERE c.tituloEleitorNumero = :tituloEleitorNumero"),
    @NamedQuery(name = "Colaborador.findByTituloEleitorSerie", query = "SELECT c FROM Colaborador c WHERE c.tituloEleitorSerie = :tituloEleitorSerie"),
    @NamedQuery(name = "Colaborador.findByTituloEleitorUF", query = "SELECT c FROM Colaborador c WHERE c.tituloEleitorUF = :tituloEleitorUF"),
    @NamedQuery(name = "Colaborador.findByCartaoTransporte", query = "SELECT c FROM Colaborador c WHERE c.cartaoTransporte = :cartaoTransporte")})
@DiscriminatorValue(value = "CO")
public class Colaborador extends PessoaFisica implements Serializable, IColaborador {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 8, max = 255)
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissaoData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaborador")
    private Collection<ColaboradorCarreiraX> colaboradorCarreiraXCollection;
    @OneToMany(mappedBy = "responsavel")
    private Collection<SolicitacaoHistorico> solicitacaoHistoricoCollection;
    @OneToMany(mappedBy = "colaborador")
    private Collection<ColaboradorBeneficioX> colaboradorBeneficioXCollection;
    @ManyToMany
    private List<ColaboradorBeneficio> colaboradorBeneficios;
    @ManyToMany(mappedBy = "colaboradores")
    private List<ColaboradorCarreira> colaboradorCarreiras;

    public Colaborador() {
    }

    public Colaborador(Integer id) {
        this.id = id;
    }

    public Colaborador(Integer id, String senha, Date admissaoData) {
        this.id = id;
        this.senha = senha;
        this.admissaoData = admissaoData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getAdmissaoData() {
        return admissaoData;
    }

    public void setAdmissaoData(Date admissaoData) {
        this.admissaoData = admissaoData;
    }

    @XmlTransient
    public Collection<ColaboradorCarreiraX> getColaboradorCarreiraXCollection() {
        return colaboradorCarreiraXCollection;
    }

    public void setColaboradorCarreiraXCollection(Collection<ColaboradorCarreiraX> colaboradorCarreiraXCollection) {
        this.colaboradorCarreiraXCollection = colaboradorCarreiraXCollection;
    }

    @XmlTransient
    public Collection<SolicitacaoHistorico> getSolicitacaoHistoricoCollection() {
        return solicitacaoHistoricoCollection;
    }

    public void setSolicitacaoHistoricoCollection(Collection<SolicitacaoHistorico> solicitacaoHistoricoCollection) {
        this.solicitacaoHistoricoCollection = solicitacaoHistoricoCollection;
    }

    @XmlTransient
    public Collection<ColaboradorBeneficioX> getColaboradorBeneficioXCollection() {
        return colaboradorBeneficioXCollection;
    }

    public void setColaboradorBeneficioXCollection(Collection<ColaboradorBeneficioX> colaboradorBeneficioXCollection) {
        this.colaboradorBeneficioXCollection = colaboradorBeneficioXCollection;
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
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
