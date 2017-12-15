/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.controller;



import com.avisora.ejb.OpcionFacadeLocal;
import com.avisora.ejb.OpcionUsuarioFacadeLocal;
import com.avisora.model.Opcion;
import com.avisora.model.OpcionUsuario;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;

@Named
@SessionScoped
public class UsuarioOpcionController implements Serializable {

    @EJB
    private OpcionUsuarioFacadeLocal EJBUsuarioOpcion;
    @EJB
    private OpcionFacadeLocal EJBOpcio;
    private List<OpcionUsuario> lista_permisos;
    private OpcionUsuario op_us;
    private Opcion op;
    private List<Opcion> lista_menu;

    public List<Opcion> getLista_menu() {
        return lista_menu;
    }

    public void setLista_menu(List<Opcion> lista_menu) {
        this.lista_menu = lista_menu;
    }

    public Opcion getOp() {
        return op;
    }

    public void setOp(Opcion op) {
        this.op = op;
    }

    public OpcionUsuario getOp_us() {
        return op_us;
    }

    public void setOp_us(OpcionUsuario op_us) {
        this.op_us = op_us;
    }

    public List<OpcionUsuario> getLista_permisos() {
        return lista_permisos;
    }

    public void setLista_permisos(List<OpcionUsuario> lista_permisos) {
        this.lista_permisos = lista_permisos;
    }

    @PostConstruct
    public void init() {

        op_us = new OpcionUsuario();
        lista_permisos = EJBUsuarioOpcion.findAll();
        lista_menu = EJBOpcio.findAll();

    }
    
    
    public void mostar(){
        
       
        
    }

}
