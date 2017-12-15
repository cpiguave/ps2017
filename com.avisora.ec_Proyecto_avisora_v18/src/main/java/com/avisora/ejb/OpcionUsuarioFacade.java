/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.ejb;

import com.avisora.model.OpcionUsuario;
import com.avisora.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 * @author avmei
 */
@Stateless
public class OpcionUsuarioFacade extends AbstractFacade<OpcionUsuario> implements OpcionUsuarioFacadeLocal {

    @PersistenceContext(unitName = "com.avisora.ec_Proyecto_avisora_v1_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionUsuarioFacade() {
        super(OpcionUsuario.class);
    }

    public void UsuarioMenu() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<OpcionUsuario> crit = cb.createQuery(OpcionUsuario.class);
        Root<OpcionUsuario> opRoot = crit.from(OpcionUsuario.class);
        opRoot.alias("p");

        Path namefield = opRoot.get("idOpcion");
        crit.select(namefield);
        crit.toString();

    }

}
