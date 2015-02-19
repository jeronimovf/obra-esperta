/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.PessoaFisica;
import br.com.obraesperta.maven.si.entities.PessoaJuridica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class PessoaJuridicaFacade extends AbstractFacade<PessoaJuridica> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaJuridicaFacade() {
        super(PessoaJuridica.class);
    }

    public PessoaJuridica getPessoaJuridicaPorCnpj(String cnpj) {
        TypedQuery<PessoaJuridica> query = getEntityManager().createNamedQuery("PessoaJuridica.findByCnpj", PessoaJuridica.class);
        query.setParameter("cnpj", cnpj);
        return query.getSingleResult(); 
    }
    
}
