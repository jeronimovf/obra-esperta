/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.EstadoCivil;
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
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }
    
    public List<EstadoCivil> getItemsCompletedFromText(String text) {
        TypedQuery<EstadoCivil> query = getEntityManager().createNamedQuery("EstadoCivil.findItemsCompletedFromText", EstadoCivil.class);
        query.setParameter("nome", "%" + text + "%");
        return query.getResultList();
    }      
    
}
