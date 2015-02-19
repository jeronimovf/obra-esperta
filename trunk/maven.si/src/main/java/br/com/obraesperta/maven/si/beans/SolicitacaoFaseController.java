package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.SolicitacaoFase;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitacaoFaseController")
@ViewScoped
public class SolicitacaoFaseController extends AbstractController<SolicitacaoFase> implements Serializable {

    public SolicitacaoFaseController() {
        super(SolicitacaoFase.class);
    }

}
