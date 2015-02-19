/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.obraesperta.maven.si.singletons.Singletons;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "ColaboradorCarreira.findAll", query = "SELECT c FROM ColaboradorCarreira c"),
    @NamedQuery(name = "ColaboradorCarreira.findById", query = "SELECT c FROM ColaboradorCarreira c WHERE c.id = :id"),
    @NamedQuery(name = "ColaboradorCarreira.findByNivel", query = "SELECT c FROM ColaboradorCarreira c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "ColaboradorCarreira.findByAtivoDesde", query = "SELECT c FROM ColaboradorCarreira c WHERE c.ativoDesde = :ativoDesde"),
    @NamedQuery(name = "ColaboradorCarreira.findByAtivoAte", query = "SELECT c FROM ColaboradorCarreira c WHERE c.ativoAte = :ativoAte")})
public class ColaboradorCarreira implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    private int nivel;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoAte;
    @JoinColumn(name = "funcao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ColaboradorFuncao funcao;
    @ManyToMany
    private Collection<Colaborador> colaboradores;
    @OneToMany
    private Collection<CarreiraSalarioItem> salarios;

    public ColaboradorCarreira() {
    }

    public ColaboradorCarreira(Integer id) {
        this.id = id;
    }

    public ColaboradorCarreira(Integer id, int nivel, Date ativoDesde) {
        this.id = id;
        this.nivel = nivel;
        this.ativoDesde = ativoDesde;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Date getAtivoDesde() {
        return ativoDesde;
    }

    public void setAtivoDesde(Date ativoDesde) {
        this.ativoDesde = ativoDesde;
    }

    public Date getAtivoAte() {
        return ativoAte;
    }

    public void setAtivoAte(Date ativoAte) {
        this.ativoAte = ativoAte;
    }

    public ColaboradorFuncao getFuncao() {
        return funcao;
    }

    public void setFuncao(ColaboradorFuncao funcao) {
        this.funcao = funcao;
    }

    public Collection<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Collection<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Collection<CarreiraSalarioItem> getSalarios() {
        return salarios;
    }

    public void setSalarios(Collection<CarreiraSalarioItem> salarios) {
        this.salarios = salarios;
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
        if (!(object instanceof ColaboradorCarreira)) {
            return false;
        }
        ColaboradorCarreira other = (ColaboradorCarreira) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNivel() + " De: " + Singletons.getInstance().getDateFormatMedium().format(getAtivoDesde()) +
                " até: " + Singletons.getInstance().getDateFormatMedium().format(getAtivoAte());
    }
    
}
