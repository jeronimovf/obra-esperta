package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.ColaboradorBeneficioX;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "colaboradorBeneficioXController")
@ViewScoped
public class ColaboradorBeneficioXController extends AbstractController<ColaboradorBeneficioX> implements Serializable {

    public ColaboradorBeneficioXController() {
        super(ColaboradorBeneficioX.class);
    }

}
