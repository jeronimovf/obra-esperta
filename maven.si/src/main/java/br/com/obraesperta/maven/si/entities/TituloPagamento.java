/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
public class TituloPagamento implements Serializable {
    @OneToMany(mappedBy = "titulo")
    private List<FluxoCaixa> fluxosCaixas;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String numero;
    @ManyToOne
    private Banco banco;
    private String codigoBarras;
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    private String cedenteCodigo;
    private String nossoNumero;
    private Double valor;
    private String carteira;
    private String sacado;
    @Temporal(TemporalType.DATE)    
    private Date emitidoEm;
    private String cedente;
    private String documentoReferencia;//Número do contrato, da NF
    private String especie;
    private Boolean aceite;
    

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
        if (!(object instanceof TituloPagamento)) {
            return false;
        }
        TituloPagamento other = (TituloPagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.obraesperta.maven.si.entities.TituloPagamento[ id=" + id + " ]";
    }
    
}
