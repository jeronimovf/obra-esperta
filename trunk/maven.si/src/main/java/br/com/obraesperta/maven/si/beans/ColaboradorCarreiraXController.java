package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.ColaboradorCarreiraX;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "colaboradorCarreiraXController")
@ViewScoped
public class ColaboradorCarreiraXController extends AbstractController<ColaboradorCarreiraX> implements Serializable {

    public ColaboradorCarreiraXController() {
        super(ColaboradorCarreiraX.class);
    }

}
