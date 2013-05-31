/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 *
 * @author User
 */
@Entity
public class PessoaFisica extends Pessoa implements IColaborador, IUsuarioSistema  {
    @Embedded
    private CPF cpf;

    @Override
    public int hashCode() {
        int hash = 0;
        //hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        /*if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        //return "pojo.PessoaFisica[ id=" + id + " ]";
        return "";
    }
    
}
