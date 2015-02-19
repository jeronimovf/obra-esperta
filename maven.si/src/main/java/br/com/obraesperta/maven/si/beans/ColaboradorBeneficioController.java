package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.ColaboradorBeneficio;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "colaboradorBeneficioController")
@ViewScoped
public class ColaboradorBeneficioController extends AbstractController<ColaboradorBeneficio> implements Serializable {

    public ColaboradorBeneficioController() {
        super(ColaboradorBeneficio.class);
    }

}
