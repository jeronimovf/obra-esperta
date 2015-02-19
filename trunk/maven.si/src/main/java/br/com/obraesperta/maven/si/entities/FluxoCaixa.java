/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Entity
public class FluxoCaixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=1, max=1)
    private String operacao;
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Temporal(TemporalType.DATE)
    private Date liquidacaoEfetiva;
    @NotNull
    @Size(min=10, max=255)
    private String historico;
    @NotNull
    private Integer parcelaNum;
    @NotNull
    private Integer parcelaTotal;
    @NotNull
    private Double valor;
    private Double liquidadoMulta;
    private Double liquidadoJuros;
    private Double liquidadeDesconto;
    @NotNull
    @ManyToOne
    private PagamentoForma pagamentoForma;
    @ManyToOne
    private TituloPagamento titulo;
    @NotNull
    @ManyToOne
    private Solicitacao solicitacao;
    @NotNull
    @ManyToOne
    private Compra compra;

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
        if (!(object instanceof FluxoCaixa)) {
            return false;
        }
        FluxoCaixa other = (FluxoCaixa) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.maven.si.entities.FluxoCaixa[ id=" + id + " ]";
    }

    /**
     * @return the operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the vencimento
     */
    public Date getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the liquidacaoEfetiva
     */
    public Date getLiquidacaoEfetiva() {
        return liquidacaoEfetiva;
    }

    /**
     * @param liquidacaoEfetiva the liquidacaoEfetiva to set
     */
    public void setLiquidacaoEfetiva(Date liquidacaoEfetiva) {
        this.liquidacaoEfetiva = liquidacaoEfetiva;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @param historico the historico to set
     */
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * @return the parcelaNum
     */
    public Integer getParcelaNum() {
        return parcelaNum;
    }

    /**
     * @param parcelaNum the parcelaNum to set
     */
    public void setParcelaNum(Integer parcelaNum) {
        this.parcelaNum = parcelaNum;
    }

    /**
     * @return the parcelaTotal
     */
    public Integer getParcelaTotal() {
        return parcelaTotal;
    }

    /**
     * @param parcelaTotal the parcelaTotal to set
     */
    public void setParcelaTotal(Integer parcelaTotal) {
        this.parcelaTotal = parcelaTotal;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the pagamentoForma
     */
    public PagamentoForma getPagamentoForma() {
        return pagamentoForma;
    }

    /**
     * @param pagamentoForma the pagamentoForma to set
     */
    public void setPagamentoForma(PagamentoForma pagamentoForma) {
        this.pagamentoForma = pagamentoForma;
    }

    /**
     * @return the titulo
     */
    public TituloPagamento getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(TituloPagamento titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the solicitacao
     */
    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    /**
     * @param solicitacao the solicitacao to set
     */
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * @return the liquidadoMulta
     */
    public Double getLiquidadoMulta() {
        return liquidadoMulta;
    }

    /**
     * @param liquidadoMulta the liquidadoMulta to set
     */
    public void setLiquidadoMulta(Double liquidadoMulta) {
        this.liquidadoMulta = liquidadoMulta;
    }

    /**
     * @return the liquidadoJuros
     */
    public Double getLiquidadoJuros() {
        return liquidadoJuros;
    }

    /**
     * @param liquidadoJuros the liquidadoJuros to set
     */
    public void setLiquidadoJuros(Double liquidadoJuros) {
        this.liquidadoJuros = liquidadoJuros;
    }

    /**
     * @return the liquidadeDesconto
     */
    public Double getLiquidadeDesconto() {
        return liquidadeDesconto;
    }

    /**
     * @param liquidadeDesconto the liquidadeDesconto to set
     */
    public void setLiquidadeDesconto(Double liquidadeDesconto) {
        this.liquidadeDesconto = liquidadeDesconto;
    }
    
}
