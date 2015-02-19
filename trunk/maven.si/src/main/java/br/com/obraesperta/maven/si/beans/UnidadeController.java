package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Unidade;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "unidadeController")
@ViewScoped
public class UnidadeController extends AbstractController<Unidade> implements Serializable {

    public UnidadeController() {
        super(Unidade.class);
    }

}
