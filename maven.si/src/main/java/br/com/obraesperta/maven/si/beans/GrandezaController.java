package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Grandeza;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "grandezaController")
@ViewScoped
public class GrandezaController extends AbstractController<Grandeza> implements Serializable {

    public GrandezaController() {
        super(Grandeza.class);
    }

}
