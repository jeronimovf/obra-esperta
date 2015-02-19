/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.obraesperta.maven.si.controllers;

import br.com.obraesperta.maven.si.entities.BancoConta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class BancoContaFacade extends AbstractFacade<BancoConta> {
    @PersistenceContext(unitName = "br.com.obraesperta.pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BancoContaFacade() {
        super(BancoConta.class);
    }
    
}
