/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Entity
public class PlanoManutencaoItem implements Serializable {
    @ManyToOne
    private PlanoManutencao planoManutencao;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @ManyToOne
    private ColaboradorFuncao funcao;
    @NotNull
    private Double valor1aHora;
    @NotNull
    private Double valorHora;
    @NotNull
    private Double valorDia;
    @NotNull
    private Double valorMes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof PlanoManutencaoItem)) {
            return false;
        }
        PlanoManutencaoItem other = (PlanoManutencaoItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.maven.si.entities.PlanoManutencaoItem[ id=" + id + " ]";
    }

    /**
     * @return the funcao
     */
    public ColaboradorFuncao getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(ColaboradorFuncao funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the valor1aHora
     */
    public Double getValor1aHora() {
        return valor1aHora;
    }

    /**
     * @param valor1aHora the valor1aHora to set
     */
    public void setValor1aHora(Double valor1aHora) {
        this.valor1aHora = valor1aHora;
    }

    /**
     * @return the valorHora
     */
    public Double getValorHora() {
        return valorHora;
    }

    /**
     * @param valorHora the valorHora to set
     */
    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    /**
     * @return the valorDia
     */
    public Double getValorDia() {
        return valorDia;
    }

    /**
     * @param valorDia the valorDia to set
     */
    public void setValorDia(Double valorDia) {
        this.valorDia = valorDia;
    }

    /**
     * @return the valorMes
     */
    public Double getValorMes() {
        return valorMes;
    }

    /**
     * @param valorMes the valorMes to set
     */
    public void setValorMes(Double valorMes) {
        this.valorMes = valorMes;
    }


    /**
     * @return the planoManutencao
     */
    public PlanoManutencao getPlanoManutencao() {
        return planoManutencao;
    }

    /**
     * @param planoManutencao the planoManutencao to set
     */
    public void setPlanoManutencao(PlanoManutencao planoManutencao) {
        this.planoManutencao = planoManutencao;
    }
    
}
