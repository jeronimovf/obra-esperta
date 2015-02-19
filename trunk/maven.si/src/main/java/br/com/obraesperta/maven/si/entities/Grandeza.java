/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Grandeza.findAll", query = "SELECT g FROM Grandeza g"),
    @NamedQuery(name = "Grandeza.findById", query = "SELECT g FROM Grandeza g WHERE g.id = :id"),
    @NamedQuery(name = "Grandeza.findByNome", query = "SELECT g FROM Grandeza g WHERE g.nome = :nome")})
public class Grandeza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String nome;
    @JoinColumn(name = "unidadeBasica", referencedColumnName = "id")
    @ManyToOne
    private Unidade unidadeBasica;
    @OneToMany
    private Collection<Unidade> unidades;

    public Grandeza() {
    }

    public Grandeza(Integer id) {
        this.id = id;
    }

    public Grandeza(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public Unidade getUnidadeBasica() {
        return unidadeBasica;
    }

    public void setUnidadeBasica(Unidade unidadeBasica) {
        this.unidadeBasica = unidadeBasica;
    }

    public Collection<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(Collection<Unidade> unidades) {
        this.unidades = unidades;
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
        if (!(object instanceof Grandeza)) {
            return false;
        }
        Grandeza other = (Grandeza) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getNome() + " (" + getUnidadeBasica().getSigla() + ")";
    }
    
}
