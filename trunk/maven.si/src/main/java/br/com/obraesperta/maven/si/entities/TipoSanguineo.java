/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity
public class TipoSanguineo implements Serializable {
    @OneToMany(mappedBy = "tipoSanguineo")
    private List<PessoaFisica> pessoas;
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 1, max = 2)
    private String abo;
    @NotNull
    @Size(min = 1, max = 1)
    private String fatorRH;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof TipoSanguineo)) {
            return false;
        }
        TipoSanguineo other = (TipoSanguineo) object;
        return (this.getId() != null || other.getId() == null) && (this.getId() == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return getAbo() + getFatorRH();
    }

    /**
     * @return the abo
     */
    public String getAbo() {
        return abo;
    }

    /**
     * @param abo the abo to set
     */
    public void setAbo(String abo) {
        this.abo = abo;
    }

    /**
     * @return the fatorRH
     */
    public String getFatorRH() {
        return fatorRH;
    }

    /**
     * @param fatorRH the fatorRH to set
     */
    public void setFatorRH(String fatorRH) {
        this.fatorRH = fatorRH;
    }
    
}
