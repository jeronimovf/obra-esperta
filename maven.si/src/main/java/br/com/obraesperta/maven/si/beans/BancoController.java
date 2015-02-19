package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.controllers.BancoFacade;
import br.com.obraesperta.maven.si.entities.Banco;
import br.com.obraesperta.maven.si.entities.BancoAgencia;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

@Named(value = "bancoController")
@ViewScoped
public class BancoController extends AbstractController<Banco> implements Serializable {

    private BancoAgencia agenciaSelected;

    public BancoController() {
        super(Banco.class);
    }

    public List<Banco> completeItemsFromText(String text) {
        BancoFacade bancoFacade = (BancoFacade) this.ejbFacade;
        return bancoFacade.getItemsCompletedFromText(text);
    }

   

    /**
     * @return the agenciaSelected
     */
    public BancoAgencia getAgenciaSelected() {
        return agenciaSelected;
    }

    /**
     * @param agenciaSelected the agenciaSelected to set
     */
    public void setAgenciaSelected(BancoAgencia agenciaSelected) {
        this.agenciaSelected = agenciaSelected;
    }
}
