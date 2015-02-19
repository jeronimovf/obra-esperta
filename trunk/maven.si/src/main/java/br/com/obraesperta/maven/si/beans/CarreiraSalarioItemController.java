package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.CarreiraSalarioItem;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "carreiraSalarioItemController")
@ViewScoped
public class CarreiraSalarioItemController extends AbstractController<CarreiraSalarioItem> implements Serializable {

    public CarreiraSalarioItemController() {
        super(CarreiraSalarioItem.class);
    }

}
