/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.Sexo;
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
public class SexoFacade extends AbstractFacade<Sexo> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SexoFacade() {
        super(Sexo.class);
    }
    
    public List<Sexo> getItemsCompletedFromText(String text) {
        TypedQuery<Sexo> query = getEntityManager().createNamedQuery("Sexo.findItemsCompletedFromText", Sexo.class);
        query.setParameter("nome", "%" + text + "%");
        return query.getResultList();
    }      
    
}
