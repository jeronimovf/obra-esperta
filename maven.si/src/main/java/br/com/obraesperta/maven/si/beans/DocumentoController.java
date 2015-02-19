package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Documento;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "documentoController")
@ViewScoped
public class DocumentoController extends AbstractController<Documento> implements Serializable {

    public DocumentoController() {
        super(Documento.class);
    }

}
