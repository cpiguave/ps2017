/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.controller;

import com.avisora.ejb.OpcionFacadeLocal;
import com.avisora.ejb.OpcionUsuarioFacadeLocal;
import com.avisora.ejb.UsuarioFacadeLocal;
import com.avisora.model.Opcion;
import com.avisora.model.OpcionUsuario;

import com.avisora.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author avmei
 */
@Named
@ViewScoped
public class PermisosController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEjb;
    private List<Usuario> usuario;

    private Usuario usuario1;

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public OpcionUsuario getOpcion_usuario() {
        return opcion_usuario;
    }

    public void setOpcion_usuario(OpcionUsuario opcion_usuario) {
        this.opcion_usuario = opcion_usuario;
    }

    private List<Opcion> lista;
    private List<Opcion> lista_select;

    @EJB
    private OpcionFacadeLocal EJBOpcion;
    private Opcion selectedOpcion;

    private OpcionUsuario opcion_usuario;

    @EJB
    private OpcionUsuarioFacadeLocal EjbOp_Us;

    public List<Opcion> getLista() {
        return lista;
    }

    public void setLista(List<Opcion> lista) {
        this.lista = lista;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    @PostConstruct
    public void init() {

        opcion_usuario = new OpcionUsuario();
        lista_select = new ArrayList<>();
        usuario = usuarioEjb.findAll();
        this.listarOpciones();
        selectedOpcion = new Opcion();
        usuario1 = new Usuario();

    }

    public List<Opcion> getLista_select() {
        return lista_select;
    }

    public void setLista_select(List<Opcion> lista_select) {
        this.lista_select = lista_select;
    }

    public void listarOpciones() {
        try {
            lista = EJBOpcion.findAll();
        } catch (Exception e) {
        }
    }

    public Opcion getSelectOpcion() {
        return selectedOpcion;
    }

    public void setSelectedOpcion(Opcion selectedOpcion) {
        this.selectedOpcion = selectedOpcion;
    }

    public void registar_Op_Us() {
        try {
              int con=0;
                
            for(Opcion a:lista_select){
          con++; 
          
          selectedOpcion= a;
                System.out.println("item : "+con +"id: "+a.getIdOpcion());
                //Opcion au=(Opcion)a.getIdOpcion()
             
            opcion_usuario.setIdOpcion(selectedOpcion);
            opcion_usuario.setIdUsuario(usuario1);
            
            EjbOp_Us.remove(opcion_usuario);
          
            EjbOp_Us.create(opcion_usuario);
            
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso ", "Se Registro"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso error", "Error"));
            System.out.println("com.avisora.controller.OpcionController.registar()" + e);
        }

    }

}
