package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Workflow;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "workflowController")
@ViewScoped
public class WorkflowController extends AbstractController<Workflow> implements Serializable {

    public WorkflowController() {
        super(Workflow.class);
    }

}
