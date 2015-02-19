/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.Cliente;
import br.com.obraesperta.maven.si.entities.Pessoa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public Cliente getClientePorPessoa(Pessoa pessoa) {
        TypedQuery<Cliente> query = getEntityManager().createNamedQuery("Cliente.findByPessoa", Cliente.class);
        query.setParameter("pessoa", pessoa);
        try{
            return query.getSingleResult();
        }
        catch (NoResultException ex) {
            return null;
        }
    }
    
}
