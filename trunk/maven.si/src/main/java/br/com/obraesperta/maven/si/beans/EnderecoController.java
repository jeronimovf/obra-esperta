package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Endereco;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "enderecoController")
@ViewScoped
public class EnderecoController extends AbstractController<Endereco> implements Serializable {

    public EnderecoController() {
        super(Endereco.class);
    }

}
