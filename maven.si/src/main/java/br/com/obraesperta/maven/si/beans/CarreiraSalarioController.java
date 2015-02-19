package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.CarreiraSalario;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "carreiraSalarioController")
@ViewScoped
public class CarreiraSalarioController extends AbstractController<CarreiraSalario> implements Serializable {

    public CarreiraSalarioController() {
        super(CarreiraSalario.class);
    }

}
