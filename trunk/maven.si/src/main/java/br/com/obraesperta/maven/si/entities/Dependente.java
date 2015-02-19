/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Entity
@DiscriminatorValue(value = "DE")
public class Dependente extends PessoaFisica implements Serializable {
    @ManyToOne
    private PessoaFisica titular;
    @NotNull
    private String relacaoDependencia;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    private Date dataFim;    
    private static final long serialVersionUID = 1L;


    /**
     * @return the relacaoDependencia
     */
    public String getRelacaoDependencia() {
        return relacaoDependencia;
    }

    /**
     * @param relacaoDependencia the relacaoDependencia to set
     */
    public void setRelacaoDependencia(String relacaoDependencia) {
        this.relacaoDependencia = relacaoDependencia;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Date getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the titular
     */
    public PessoaFisica getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(PessoaFisica titular) {
        this.titular = titular;
    }
  
}
