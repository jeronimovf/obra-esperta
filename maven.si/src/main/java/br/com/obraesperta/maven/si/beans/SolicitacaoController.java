package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Solicitacao;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitacaoController")
@ViewScoped
public class SolicitacaoController extends AbstractController<Solicitacao> implements Serializable {

    public SolicitacaoController() {
        super(Solicitacao.class);
    }

}
