/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
public class Colaborador extends PessoaFisica{
    private String senha;
    @Temporal (TemporalType.DATE)
    private Date admissao;
    private String pisPasep;
    private String ctps;
    private String cartaoTransporte;
}
