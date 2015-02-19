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
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "ColaboradorBeneficio.findAll", query = "SELECT c FROM ColaboradorBeneficio c"),
    @NamedQuery(name = "ColaboradorBeneficio.findById", query = "SELECT c FROM ColaboradorBeneficio c WHERE c.id = :id"),
    @NamedQuery(name = "ColaboradorBeneficio.findByNome", query = "SELECT c FROM ColaboradorBeneficio c WHERE c.nome = :nome"),
    @NamedQuery(name = "ColaboradorBeneficio.findByAtivoDesde", query = "SELECT c FROM ColaboradorBeneficio c WHERE c.ativoDesde = :ativoDesde"),
    @NamedQuery(name = "ColaboradorBeneficio.findByAtivoAte", query = "SELECT c FROM ColaboradorBeneficio c WHERE c.ativoAte = :ativoAte")})
public class ColaboradorBeneficio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoDesde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ativoAte;
    @ManyToMany(mappedBy = "colaboradorBeneficios")
    private Collection<Colaborador> colaboradores;

    public ColaboradorBeneficio() {
    }

    public ColaboradorBeneficio(Integer id) {
        this.id = id;
    }

    public ColaboradorBeneficio(Integer id, String nome, Date ativoDesde) {
        this.id = id;
        this.nome = nome;
        this.ativoDesde = ativoDesde;
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

    public Collection<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Collection<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
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
        if (!(object instanceof ColaboradorBeneficio)) {
            return false;
        }
        ColaboradorBeneficio other = (ColaboradorBeneficio) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNome() + " De: " + Singletons.getInstance().getDateFormatMedium().format(getAtivoDesde()) + " até: " + 
                Singletons.getInstance().getDateFormatMedium().format(getAtivoAte());
    }
    
}
