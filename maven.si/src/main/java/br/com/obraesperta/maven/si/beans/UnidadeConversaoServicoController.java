package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.UnidadeConversaoServico;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "unidadeConversaoServicoController")
@ViewScoped
public class UnidadeConversaoServicoController extends AbstractController<UnidadeConversaoServico> implements Serializable {

    public UnidadeConversaoServicoController() {
        super(UnidadeConversaoServico.class);
    }

}
