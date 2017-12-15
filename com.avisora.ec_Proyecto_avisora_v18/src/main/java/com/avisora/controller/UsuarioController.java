/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.controller;

import com.avisora.ejb.UsuarioFacadeLocal;
import com.avisora.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped

public class UsuarioController implements Serializable {

 
   
    private Usuario usuario;
    private Usuario usuarioSelect;
    private String accion;
    private Date currentDate;
    private List<Usuario> usuario_list;
    private List<Usuario> usuario_filter;
    @EJB
    private UsuarioFacadeLocal UsuarioEJB;
    private boolean ocultar = false;
    private boolean habilitado = true;
    private boolean text = true;

  



    public boolean isOcultar() {
        return ocultar;
    }

    public void setOcultar(boolean ocultar) {
        this.ocultar = ocultar;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Usuario getUsuarioSelect() {
        return usuarioSelect;
    }

    public void setUsuarioSelect(Usuario usuarioSelect) {
        this.usuarioSelect = usuarioSelect;
    }

 
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Usuario> getUsuario_filter() {
        return usuario_filter;
    }

    public void setUsuario_filter(List<Usuario> usuario_filter) {
        this.usuario_filter = usuario_filter;
    }

    public List<Usuario> getUsuario_list() {
        return usuario_list;
    }

    public void setUsuario_list(List<Usuario> usuario_list) {
        this.usuario_list = usuario_list;
    }
    
       public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }


    @PostConstruct
    public void init() {
        usuario = new Usuario();
        currentDate = new Date();
        usuario_list = UsuarioEJB.findAll();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void registar() {
        try {
            System.out.println("sss" + currentDate);

            UsuarioEJB.create(usuario);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso ", "Se Registro"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso error", "Error"));
        }

    }

    public void EliminarU() {
        if (usuarioSelect != null) {

            UsuarioEJB.remove(usuarioSelect);

        } else {

        }
        resetearFormulario();
        init();
    }

    public void GuardarActualizar() {
        FacesMessage mensaje = new FacesMessage();
        try {
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
            if (usuarioSelect != null) {
                UsuarioEJB.edit(usuario);

            } else {
                UsuarioEJB.create(usuario);
            }
            resetearFormulario();
            init();

        } catch (Exception e) {

            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
        }

    }

    public void update() {

        try {
            habtxt();
            UsuarioEJB.edit(usuario);

        } catch (Exception e) {
            System.out.println("" + e);
        }

        resetearFormulario();
        init();

    }

    public void modificar() {
        if (usuarioSelect != null) {
            setUsuario(usuarioSelect);
            habilitarUsu();

        } else {

        }

    }

    public void visualizar() {
        habilitarUsu();
        mostarRender();

    }

    public void resetearFormulario() {
        this.usuario = new Usuario();
        this.usuarioSelect = null;
        habilitarUsu();
        mostarRender();

    }

    public void SelecionUsuario(SelectEvent event) {
        usuarioSelect = (Usuario) event.getObject();

    }

    public void deshabilitarUsu() {
        habilitado = true;
    }

    public void habilitarUsu() {
        habilitado = false;
    }

    public void mostarRender() {
        ocultar = true;

    }

    public void ocultarRender() {
        ocultar = false;

    }

    public void destxt() {
        text = true;
    }

    public void habtxt() {
        text = false;
    }
   

}
