package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Campanha;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "campanhaController")
@ViewScoped
public class CampanhaController extends AbstractController<Campanha> implements Serializable {

    public CampanhaController() {
        super(Campanha.class);
    }

}
