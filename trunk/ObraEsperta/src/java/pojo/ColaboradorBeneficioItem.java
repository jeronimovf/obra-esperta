/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
class ColaboradorBeneficioItem{
    private Beneficio beneficio;
    private Colaborador colaborador;
    @Temporal (TemporalType.DATE)
    @Column (nullable = false)        
    private Date opcaoDataConcessao;
    @Temporal (TemporalType.DATE)    
    private Date opcaoDataRevogacao;
}
