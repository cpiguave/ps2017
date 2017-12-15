/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.controller;

import com.avisora.ejb.UsuarioFacadeLocal;
import com.avisora.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class indexController implements Serializable {

    @EJB
    private UsuarioFacadeLocal EJBUsuario;
    int con = 0;
    private Usuario usuario;
    int hab = 1;

    private List<Usuario> lista_u;

    public List<Usuario> getLista_u() {
        return lista_u;
    }

    public void setLista_u(List<Usuario> lista_u) {
        this.lista_u = lista_u;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        lista_u = EJBUsuario.findAll();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {

        Usuario us;
        String redireccion = null;

        try {
            us = EJBUsuario.iniciarsesion(usuario);
            if (us != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion = "/Protegido/Inicio?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso Credenciales Incorrectas", "Credenciales Incorrectas"));
                if (con == 3) {
                    redireccion = "/Clieen_Bloqueo?faces-redirect=true";
                    usuario.setCtrHabilitado();
                    EJBUsuario.edit(usuario);
                }

            }

        } catch (Exception e) {

            // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso base", "Error Inicio Sessión"));
        }
        return redireccion;
    }

}
