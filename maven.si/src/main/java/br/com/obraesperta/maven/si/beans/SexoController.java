package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.SexoFacade;
import br.com.obraesperta.maven.si.entities.Sexo;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "sexoController")
@ViewScoped
public class SexoController extends AbstractController<Sexo> implements Serializable {

    public SexoController() {
        super(Sexo.class);
    }

    
    public List<Sexo> completeItemsFromText(String text){
        SexoFacade sexoFacade = (SexoFacade)this.ejbFacade;
        return sexoFacade.getItemsCompletedFromText(text);
    }
}
