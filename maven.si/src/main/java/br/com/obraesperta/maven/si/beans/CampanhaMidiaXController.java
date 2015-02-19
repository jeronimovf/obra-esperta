package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.CampanhaMidiaX;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "campanhaMidiaXController")
@ViewScoped
public class CampanhaMidiaXController extends AbstractController<CampanhaMidiaX> implements Serializable {

    public CampanhaMidiaXController() {
        super(CampanhaMidiaX.class);
    }

}
