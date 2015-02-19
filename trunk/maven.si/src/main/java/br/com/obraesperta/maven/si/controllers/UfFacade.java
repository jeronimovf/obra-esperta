/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.Uf;
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
public class UfFacade extends AbstractFacade<Uf> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UfFacade() {
        super(Uf.class);
    }

    
    public List<Uf> getItemsCompletedFromText(String text) {
        TypedQuery<Uf> query = getEntityManager().createNamedQuery("Uf.findItemsCompletedFromText", Uf.class);
        query.setParameter("sigla", "%" + text + "%");
        return query.getResultList();
    }       
}
