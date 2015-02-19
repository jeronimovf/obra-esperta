package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Email;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "emailController")
@ViewScoped
public class EmailController extends AbstractController<Email> implements Serializable {

    public EmailController() {
        super(Email.class);
    }

}
