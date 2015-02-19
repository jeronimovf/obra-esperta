package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.SolicitacaoHistorico;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitacaoHistoricoController")
@ViewScoped
public class SolicitacaoHistoricoController extends AbstractController<SolicitacaoHistorico> implements Serializable {

    public SolicitacaoHistoricoController() {
        super(SolicitacaoHistorico.class);
    }

}
