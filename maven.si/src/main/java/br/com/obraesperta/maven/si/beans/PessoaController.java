package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Pessoa;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "pessoaController")
@ViewScoped
public class PessoaController extends AbstractController<Pessoa> implements Serializable {

    public PessoaController() {
        super(Pessoa.class);
    }

}
