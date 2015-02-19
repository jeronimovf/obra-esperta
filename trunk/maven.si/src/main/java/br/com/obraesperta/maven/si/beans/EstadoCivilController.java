package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.EstadoCivilFacade;
import br.com.obraesperta.maven.si.entities.EstadoCivil;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "estadoCivilController")
@ViewScoped
public class EstadoCivilController extends AbstractController<EstadoCivil> implements Serializable {

    public EstadoCivilController() {
        super(EstadoCivil.class);
    }

    
    public List<EstadoCivil> completeItemsFromText(String text){
        EstadoCivilFacade estadoCivilFacade = (EstadoCivilFacade)this.ejbFacade;
        return estadoCivilFacade.getItemsCompletedFromText(text);
    }
}
