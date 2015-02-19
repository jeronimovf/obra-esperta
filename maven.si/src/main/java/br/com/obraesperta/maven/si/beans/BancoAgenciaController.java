package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.BancoAgencia;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "bancoAgenciaController")
@ViewScoped
public class BancoAgenciaController extends AbstractController<BancoAgencia> implements Serializable {

    public BancoAgenciaController() {
        super(BancoAgencia.class);
    }

}
