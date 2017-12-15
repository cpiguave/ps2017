/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.ejb;

import com.avisora.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author avmei
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "com.avisora.ec_Proyecto_avisora_v1_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
     @Override
    public Usuario iniciarsesion(Usuario us){
       Usuario usuario =null;
       String consultar;
        try {
            
            consultar="FROM Usuario u WHERE u.nomUsuario = ?1 and u.pwdUsuario = ?2";
             Query query= em.createQuery(consultar);
             
             query.setParameter(1, us.getNomUsuario());
             query.setParameter(2, us.getPwdUsuario());
         
             
             List<Usuario> lista =query.getResultList();
          if(!lista.isEmpty()){
              usuario= lista.get(0);
          }
            
        } catch (Exception e) {
            
        throw e;
        }
   
    return  usuario;
    
    }
    //SELECT a.idUsuario FROM Usuario a Where a.nomUsuario=
    
    
    @Override
        public Usuario ExisUsuario(Usuario us){
       Usuario usuario =null;
       String consultar;
        try {
             consultar="SELECT a.idUsuario FROM Usuario a WHERE a.nomUsuario = ?1";
             Query query= em.createQuery(consultar);
             query.setParameter(1, us.getNomUsuario());
             List<Usuario> lista_u =query.getResultList();
          if(!lista_u.isEmpty()){
              usuario= lista_u.get(0);
          }
            
        } catch (Exception e) {
            
        throw e;
        }
   
    return  usuario;
    
    }
    
    
    
        
}
