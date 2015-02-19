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
    @NamedQuery(name = "SolicitacaoMaterial.findAll", query = "SELECT s FROM SolicitacaoMaterial s"),
    @NamedQuery(name = "SolicitacaoMaterial.findById", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.id = :id"),
    @NamedQuery(name = "SolicitacaoMaterial.findBySolicitacao", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.solicitacao = :solicitacao"),
    @NamedQuery(name = "SolicitacaoMaterial.findByGrupo", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.grupo = :grupo"),
    @NamedQuery(name = "SolicitacaoMaterial.findByMaterial", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.material = :material"),
    @NamedQuery(name = "SolicitacaoMaterial.findByQuantidade", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.quantidade = :quantidade"),
    @NamedQuery(name = "SolicitacaoMaterial.findByCustasDe", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.custasDe = :custasDe"),
    @NamedQuery(name = "SolicitacaoMaterial.findByValorUnitario", query = "SELECT s FROM SolicitacaoMaterial s WHERE s.valorUnitario = :valorUnitario")})
public class SolicitacaoMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private int solicitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String grupo;
    @Basic(optional = false)
    @NotNull
    private int material;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double quantidade;
    @Basic(optional = false)
    @NotNull
    private int custasDe;
    private Double valorUnitario;

    public SolicitacaoMaterial() {
    }

    public SolicitacaoMaterial(Integer id) {
        this.id = id;
    }

    public SolicitacaoMaterial(Integer id, int solicitacao, String grupo, int material, int custasDe) {
        this.id = id;
        this.solicitacao = solicitacao;
        this.grupo = grupo;
        this.material = material;
        this.custasDe = custasDe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(int solicitacao) {
        this.solicitacao = solicitacao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public int getCustasDe() {
        return custasDe;
    }

    public void setCustasDe(int custasDe) {
        this.custasDe = custasDe;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
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
        if (!(object instanceof SolicitacaoMaterial)) {
            return false;
        }
        SolicitacaoMaterial other = (SolicitacaoMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.entidades.SolicitacaoMaterial[ id=" + id + " ]";
    }
    
}
