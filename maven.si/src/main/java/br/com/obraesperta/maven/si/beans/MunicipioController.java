package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.MunicipioFacade;
import br.com.obraesperta.maven.si.entities.Municipio;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "municipioController")
@ViewScoped
public class MunicipioController extends AbstractController<Municipio> implements Serializable {
    List<Municipio> itemsOrderedByNomeUfSigla;


    public List<Municipio> getItemsOrderedByNomeUfSigla() {
        MunicipioFacade municipioFacade = (MunicipioFacade)this.ejbFacade;
        if (itemsOrderedByNomeUfSigla == null) {
            itemsOrderedByNomeUfSigla = municipioFacade.findAllOrderedByNomeUfSigla();
        }
        return itemsOrderedByNomeUfSigla;
    }

    public void setItemsOrderedByNomeUfSigla(List<Municipio> itemsOrderedByNomeUfSigla) {
        this.itemsOrderedByNomeUfSigla = itemsOrderedByNomeUfSigla;
    }

    public MunicipioController() {
        super(Municipio.class);
    }
    
    public Collection<Municipio> getItems() {
        if (items == null) {
            items = this.ejbFacade.findAll();
        }
        return items;
    }   

    public List<Municipio> completeItemsFromText(String text){
        MunicipioFacade municipioFacade = (MunicipioFacade)this.ejbFacade;
        return municipioFacade.getItemsCompletedFromText(text);
    }

}
