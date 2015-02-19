package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.SolicitacaoItem;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitacaoItemController")
@ViewScoped
public class SolicitacaoItemController extends AbstractController<SolicitacaoItem> implements Serializable {

    public SolicitacaoItemController() {
        super(SolicitacaoItem.class);
    }

}
