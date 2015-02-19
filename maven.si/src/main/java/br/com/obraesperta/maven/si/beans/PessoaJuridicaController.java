package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.PessoaJuridicaFacade;
import br.com.obraesperta.maven.si.entities.PessoaJuridica;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("pessoaJuridicaController")
@SessionScoped
public class PessoaJuridicaController extends AbstractController<PessoaJuridica> implements Serializable {

    public PessoaJuridicaController() {
        super(PessoaJuridica.class);
    }
    
    public PessoaJuridica buscaPessoaJuridicaPorCnpj(String cnpj){
        PessoaJuridicaFacade pessoaJuridicaFacade = (PessoaJuridicaFacade)this.ejbFacade;
        return pessoaJuridicaFacade.getPessoaJuridicaPorCnpj(cnpj);
    }    

}
