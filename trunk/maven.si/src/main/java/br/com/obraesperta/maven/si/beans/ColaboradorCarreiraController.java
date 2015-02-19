package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.ColaboradorCarreira;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "colaboradorCarreiraController")
@ViewScoped
public class ColaboradorCarreiraController extends AbstractController<ColaboradorCarreira> implements Serializable {

    public ColaboradorCarreiraController() {
        super(ColaboradorCarreira.class);
    }

}
