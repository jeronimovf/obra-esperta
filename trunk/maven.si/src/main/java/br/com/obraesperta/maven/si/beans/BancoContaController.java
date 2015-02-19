package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.BancoConta;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "bancoContaController")
@ViewScoped
public class BancoContaController extends AbstractController<BancoConta> implements Serializable {

    public BancoContaController() {
        super(BancoConta.class);
    }

}
