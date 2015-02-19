package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.UfFacade;
import br.com.obraesperta.maven.si.entities.Uf;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ufController")
@ViewScoped
public class UfController extends AbstractController<Uf> implements Serializable {

    public UfController() {
        super(Uf.class);
    }

    public List<Uf> completeItemsFromText(String text){
        UfFacade ufFacade = (UfFacade)this.ejbFacade;
        return ufFacade.getItemsCompletedFromText(text);
    }
}
