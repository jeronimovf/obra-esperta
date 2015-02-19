package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Telefone;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "telefoneController")
@ViewScoped
public class TelefoneController extends AbstractController<Telefone> implements Serializable {

    public TelefoneController() {
        super(Telefone.class);
    }

}
