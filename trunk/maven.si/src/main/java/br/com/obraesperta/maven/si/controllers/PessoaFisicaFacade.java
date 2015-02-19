/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.PessoaFisica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class PessoaFisicaFacade extends AbstractFacade<PessoaFisica> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaFisicaFacade() {
        super(PessoaFisica.class);
    }
    
    public List<PessoaFisica> getItemsCompletedFromText(String text) {
        TypedQuery<PessoaFisica> query = getEntityManager().createNamedQuery("PessoaFisica.findItemsCompletedFromText", PessoaFisica.class);
        query.setParameter("nome", "%" + text + "%");
        return query.getResultList();
    }          

    public PessoaFisica getPessoaFisicaPorCpf(String cpf) {
        TypedQuery<PessoaFisica> query = getEntityManager().createNamedQuery("PessoaFisica.findByCpf", PessoaFisica.class);
        query.setParameter("cpf", cpf);
        return query.getSingleResult();        
    }
}
