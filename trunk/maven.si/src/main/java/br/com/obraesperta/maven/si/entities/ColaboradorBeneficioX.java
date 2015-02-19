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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColaboradorBeneficioX.findAll", query = "SELECT c FROM ColaboradorBeneficioX c"),
    @NamedQuery(name = "ColaboradorBeneficioX.findById", query = "SELECT c FROM ColaboradorBeneficioX c WHERE c.id = :id"),
    @NamedQuery(name = "ColaboradorBeneficioX.findByOpcaoDataConcessao", query = "SELECT c FROM ColaboradorBeneficioX c WHERE c.opcaoDataConcessao = :opcaoDataConcessao"),
    @NamedQuery(name = "ColaboradorBeneficioX.findByOpcaoDataRevogacao", query = "SELECT c FROM ColaboradorBeneficioX c WHERE c.opcaoDataRevogacao = :opcaoDataRevogacao")})
public class ColaboradorBeneficioX implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date opcaoDataConcessao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date opcaoDataRevogacao;
    @JoinColumn(name = "beneficio", referencedColumnName = "id")
    @ManyToOne
    private ColaboradorBeneficio beneficio;
    @JoinColumn(name = "colaborador", referencedColumnName = "id")
    @ManyToOne
    private Colaborador colaborador;

    public ColaboradorBeneficioX() {
    }

    public ColaboradorBeneficioX(Integer id) {
        this.id = id;
    }

    public ColaboradorBeneficioX(Integer id, Date opcaoDataConcessao) {
        this.id = id;
        this.opcaoDataConcessao = opcaoDataConcessao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOpcaoDataConcessao() {
        return opcaoDataConcessao;
    }

    public void setOpcaoDataConcessao(Date opcaoDataConcessao) {
        this.opcaoDataConcessao = opcaoDataConcessao;
    }

    public Date getOpcaoDataRevogacao() {
        return opcaoDataRevogacao;
    }

    public void setOpcaoDataRevogacao(Date opcaoDataRevogacao) {
        this.opcaoDataRevogacao = opcaoDataRevogacao;
    }

    public ColaboradorBeneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(ColaboradorBeneficio beneficio) {
        this.beneficio = beneficio;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
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
        if (!(object instanceof ColaboradorBeneficioX)) {
            return false;
        }
        ColaboradorBeneficioX other = (ColaboradorBeneficioX) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.ColaboradorBeneficioX[ id=" + id + " ]";
    }
    
}
