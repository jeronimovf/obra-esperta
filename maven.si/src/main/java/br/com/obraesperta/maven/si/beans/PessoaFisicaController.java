package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.PessoaFisicaFacade;
import br.com.obraesperta.maven.si.entities.PessoaFisica;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("pessoaFisicaController")
@SessionScoped
public class PessoaFisicaController extends AbstractController<PessoaFisica> implements Serializable {

    public PessoaFisicaController() {
        super(PessoaFisica.class);
    }
    public List<PessoaFisica> completeItemsFromText(String text){
        PessoaFisicaFacade pessoaFisicaFacade = (PessoaFisicaFacade)this.ejbFacade;
        return pessoaFisicaFacade.getItemsCompletedFromText(text);
    }

    public PessoaFisica buscaPessoaFisicaPorCPF(String cpf){
        PessoaFisicaFacade pessoaFisicaFacade = (PessoaFisicaFacade)this.ejbFacade;
        return pessoaFisicaFacade.getPessoaFisicaPorCpf(cpf);
    }
}
