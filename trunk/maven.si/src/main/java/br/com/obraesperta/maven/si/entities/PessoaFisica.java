/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.entities;

import br.com.caelum.stella.bean.validation.CPF;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */



@Entity
@DiscriminatorValue("PF")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p"),
    @NamedQuery(name = "PessoaFisica.findById", query = "SELECT p FROM PessoaFisica p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "PessoaFisica.findByRg", query = "SELECT p FROM PessoaFisica p WHERE p.nome = :nome"),
    @NamedQuery(name = "PessoaFisica.findByCnhNumero", query = "SELECT p FROM PessoaFisica p WHERE p.cnhNumero = :cnhNumero"),    
    @NamedQuery(name = "PessoaFisica.findByCnhCategoria", query = "SELECT p FROM PessoaFisica p WHERE p.cnhCategoria = :cnhCategoria"),    
    @NamedQuery(name = "PessoaFisica.findItemsCompletedFromText", query = "SELECT p FROM PessoaFisica p WHERE LOWER(p.nome) LIKE lower(:nome) ORDER BY p.nome, p.cpf"),    
    @NamedQuery(name = "PessoaFisica.findByDataNascimento", query = "SELECT p FROM PessoaFisica p WHERE p.dataNascimento = :dataNascimento")})
public class PessoaFisica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 14)
    @CPF(formatted = true)
    @NotNull
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 255)
    private String rgNumero;
    @Size(max = 255)
    private String rgOrgaoExpedidor;
    @ManyToOne
    private Uf rgUF;
    @Size(max = 255)
    private String nome;
    @ManyToOne
    private Sexo sexo;
    @ManyToOne
    private EstadoCivil estadoCivil;
    @ManyToOne
    private Municipio naturalDe;
    @Size(max = 2)
    private String cnhCategoria;
    @Size(max = 255)
    private String cnhNumero;
    @Temporal(TemporalType.DATE)
    private Date cnhValidade;  
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    private String pisPasep;
    @Size(min = 1, max = 255)
    private String ctpsNumero;
    @Size(min = 1, max = 255)
    private String ctpsSerie;
    private Integer ctpsUF;
    @Size(min = 1, max = 255)
    private String tituloEleitorNumero;
    @Size(min = 1, max = 255)
    private String tituloEleitorSerie;
    private int tituloEleitorUF;
    @Size(max = 255)
    private String cartaoTransporte; 
    @ManyToOne
    private TipoSanguineo tipoSanguineo;
    private String nacionalidade;
    @OneToMany(mappedBy = "titular")
    private Collection<Dependente> dependentes;

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Municipio getNaturalDe() {
        return naturalDe;
    }

    public void setNaturalDe(Municipio naturalDe) {
        this.naturalDe = naturalDe;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRgNumero() {
        return rgNumero;
    }

    public void setRgNumero(String rgNumero) {
        this.rgNumero = rgNumero;
    }

    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
    }

    public Uf getRgUF() {
        return rgUF;
    }

    public void setRgUF(Uf rgUF) {
        this.rgUF = rgUF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnhCategoria() {
        return cnhCategoria;
    }

    public void setCnhCategoria(String cnhCategoria) {
        this.cnhCategoria = cnhCategoria;
    }

    public String getCnhNumero() {
        return cnhNumero;
    }

    public void setCnhNumero(String cnhNumero) {
        this.cnhNumero = cnhNumero;
    }

    public Date getCnhValidade() {
        return cnhValidade;
    }

    public void setCnhValidade(Date cnhValidade) {
        this.cnhValidade = cnhValidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        return (getId() != null || other.getId() == null) && (getId() == null || getId().equals(other.getId()));
    }

    @Override
    public String toString() {
        return getNome() + " (" + getCpf() + ")";
    }

    /**
     * @return the pisPasep
     */
    public String getPisPasep() {
        return pisPasep;
    }

    /**
     * @param pisPasep the pisPasep to set
     */
    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    /**
     * @return the ctpsNumero
     */
    public String getCtpsNumero() {
        return ctpsNumero;
    }

    /**
     * @param ctpsNumero the ctpsNumero to set
     */
    public void setCtpsNumero(String ctpsNumero) {
        this.ctpsNumero = ctpsNumero;
    }

    /**
     * @return the ctpsSerie
     */
    public String getCtpsSerie() {
        return ctpsSerie;
    }

    /**
     * @param ctpsSerie the ctpsSerie to set
     */
    public void setCtpsSerie(String ctpsSerie) {
        this.ctpsSerie = ctpsSerie;
    }

    /**
     * @return the ctpsUF
     */
    public Integer getCtpsUF() {
        return ctpsUF;
    }

    /**
     * @param ctpsUF the ctpsUF to set
     */
    public void setCtpsUF(Integer ctpsUF) {
        this.ctpsUF = ctpsUF;
    }

    /**
     * @return the tituloEleitorNumero
     */
    public String getTituloEleitorNumero() {
        return tituloEleitorNumero;
    }

    /**
     * @param tituloEleitorNumero the tituloEleitorNumero to set
     */
    public void setTituloEleitorNumero(String tituloEleitorNumero) {
        this.tituloEleitorNumero = tituloEleitorNumero;
    }

    /**
     * @return the tituloEleitorSerie
     */
    public String getTituloEleitorSerie() {
        return tituloEleitorSerie;
    }

    /**
     * @param tituloEleitorSerie the tituloEleitorSerie to set
     */
    public void setTituloEleitorSerie(String tituloEleitorSerie) {
        this.tituloEleitorSerie = tituloEleitorSerie;
    }

    /**
     * @return the tituloEleitorUF
     */
    public int getTituloEleitorUF() {
        return tituloEleitorUF;
    }

    /**
     * @param tituloEleitorUF the tituloEleitorUF to set
     */
    public void setTituloEleitorUF(int tituloEleitorUF) {
        this.tituloEleitorUF = tituloEleitorUF;
    }

    /**
     * @return the cartaoTransporte
     */
    public String getCartaoTransporte() {
        return cartaoTransporte;
    }

    /**
     * @param cartaoTransporte the cartaoTransporte to set
     */
    public void setCartaoTransporte(String cartaoTransporte) {
        this.cartaoTransporte = cartaoTransporte;
    }

    /**
     * @return the tipoSanguineo
     */
    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    /**
     * @param tipoSanguineo the tipoSanguineo to set
     */
    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    /**
     * @return the nacionalidade
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @param nacionalidade the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @return the dependentes
     */
    public Collection<Dependente> getDependentes() {
        return dependentes;
    }

    /**
     * @param dependentes the dependentes to set
     */
    public void setDependentes(Collection<Dependente> dependentes) {
        this.dependentes = dependentes;
    }
    
}
