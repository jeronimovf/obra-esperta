package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.CampanhaMidia;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "campanhaMidiaController")
@ViewScoped
public class CampanhaMidiaController extends AbstractController<CampanhaMidia> implements Serializable {

    public CampanhaMidiaController() {
        super(CampanhaMidia.class);
    }

}
