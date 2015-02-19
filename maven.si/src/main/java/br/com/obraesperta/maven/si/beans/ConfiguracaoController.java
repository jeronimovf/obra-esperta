package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Configuracao;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "configuracaoController")
@ViewScoped
public class ConfiguracaoController extends AbstractController<Configuracao> implements Serializable {

    public ConfiguracaoController() {
        super(Configuracao.class);
    }

}
