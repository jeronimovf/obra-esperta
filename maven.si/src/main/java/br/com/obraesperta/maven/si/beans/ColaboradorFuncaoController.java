package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.ColaboradorFuncao;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "colaboradorFuncaoController")
@ViewScoped
public class ColaboradorFuncaoController extends AbstractController<ColaboradorFuncao> implements Serializable {

    public ColaboradorFuncaoController() {
        super(ColaboradorFuncao.class);
    }

}
