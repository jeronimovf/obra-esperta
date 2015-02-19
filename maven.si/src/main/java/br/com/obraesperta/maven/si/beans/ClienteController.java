package br.com.obraesperta.maven.si.beans;

import br.com.obraesperta.maven.si.entities.Cliente;
import br.com.obraesperta.maven.si.entities.Pessoa;
import java.io.Serializable;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.obraesperta.maven.si.beans.util.JsfUtil;
import br.com.obraesperta.maven.si.controllers.ClienteFacade;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.panel.Panel;


@Named("clienteController")
@SessionScoped
public class ClienteController extends AbstractController<Cliente> implements Serializable {
    private String pessoaTipo;
    private Pessoa pessoa;
    private Panel localizadorCNPJ;
    @Inject
    private PessoaFisicaController pessoaFisicaController;
    @Inject
    private PessoaJuridicaController pessoaJuridicaController;       
    private String cpfOuCnpj;
    private Panel localizadorCPF;
    
    public Panel getLocalizadorCPF() {
        return localizadorCPF;
    }

    public void setLocalizadorCPF(Panel localizadorCPF) {
        this.localizadorCPF = localizadorCPF;
    }

    public Panel getLocalizadorCNPJ() {
        return localizadorCNPJ;
    }

    public void setLocalizadorCNPJ(Panel localizadorCNPJ) {
        this.localizadorCNPJ = localizadorCNPJ;
    }

    
    public ClienteController() {
        super(Cliente.class);
    }
    /**
     * Store a new item in the data layer.
     *
     * @param event
     */
    public void buscarPessoaPorCnpjOuCpf(ActionEvent event) {
        CPFValidator vldCPF = new CPFValidator();
        CNPJValidator vldCNPJ = new CNPJValidator();
        if (pessoaTipo.equals("PF")){
            if (vldCPF.isEligible(cpfOuCnpj)) {
                vldCPF.assertValid(cpfOuCnpj);
                buscaPessoaFisica(cpfOuCnpj);
            }            
        }
        if (pessoaTipo.equals("PJ")){
            if (vldCNPJ.isEligible(cpfOuCnpj)) {
                vldCNPJ.assertValid(cpfOuCnpj);
                buscaPessoaJuridica(cpfOuCnpj);
            }            
        }
        if (isPessoaCliente()){
            String msg = ResourceBundle.getBundle("/Bundle").getString("MensagemDeErroPessoaJaECliente");
            pessoa = null;
            JsfUtil.addErrorMessage(msg);
        }
    }

    /**
     * @return the pessoaTipo
     */
    public String getPessoaTipo() {
        return pessoaTipo;
    }

    /**
     * @param pessoaTipo the pessoaTipo to set
     */
    public void setPessoaTipo(String pessoaTipo) {
        this.pessoaTipo = pessoaTipo;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the cpfOuCnpj
     */
    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    /**
     * @param cpfOuCnpj
     */
    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }


    private void buscaPessoaFisica(String cpf) {
        setPessoa(pessoaFisicaController.buscaPessoaFisicaPorCPF(cpf));
    }

    private void buscaPessoaJuridica(String cnpj) {
        setPessoa(pessoaJuridicaController.buscaPessoaJuridicaPorCnpj(cnpj));
    }
    
    private void atualizaLocalizadores(){
        
    }

    private boolean isPessoaCliente() {
        ClienteFacade clienteFacade = (ClienteFacade)this.ejbFacade;
        setSelected(clienteFacade.getClientePorPessoa(pessoa));
        return (getSelected() !=null);
    }
}
