/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.Municipio;
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
public class MunicipioFacade extends AbstractFacade<Municipio> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }
    
    public List<Municipio> findAllOrderedByNomeUfSigla() {
        TypedQuery<Municipio> query = getEntityManager().createNamedQuery("Municipio.findAllOrderedByNomeUfSigla", Municipio.class);
        return query.getResultList();
    }
    
    public List<Municipio> getItemsCompletedFromText(String text) {
        TypedQuery<Municipio> query = getEntityManager().createNamedQuery("Municipio.findItemsCompletedFromText", Municipio.class);
        query.setParameter("nome", "%" + text + "%");
        return query.getResultList();
    }    
}
