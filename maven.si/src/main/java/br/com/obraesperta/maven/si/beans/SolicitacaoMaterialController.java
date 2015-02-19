package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.SolicitacaoMaterial;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "solicitacaoMaterialController")
@ViewScoped
public class SolicitacaoMaterialController extends AbstractController<SolicitacaoMaterial> implements Serializable {

    public SolicitacaoMaterialController() {
        super(SolicitacaoMaterial.class);
    }

}
