package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Colaborador;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "colaboradorController")
@ViewScoped
public class ColaboradorController extends AbstractController<Colaborador> implements Serializable {

    public ColaboradorController() {
        super(Colaborador.class);
    }

}
