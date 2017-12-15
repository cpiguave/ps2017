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

import com.avisora.model.Usuario;

import java.io.Serializable;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import org.primefaces.event.SelectEvent;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

@Named
@SessionScoped
public class OpcionController implements Serializable {

    @EJB
    private OpcionFacadeLocal EJBOpcion;
    private List<Opcion> lista;
    private List<Opcion> listaSeleccionada;
    private List<Object> usuAsig;

    private MenuModel model;
    private Opcion opcion;
    private Opcion opcionSelecionada;
    private OpcionUsuario us_op;
    @EJB
    private OpcionUsuarioFacadeLocal EJB_us_op;
    private List<OpcionUsuario> lista_us;

    public List<OpcionUsuario> getLista_us() {
        return lista_us;
    }

    public void setLista_us(List<OpcionUsuario> lista_us) {
        this.lista_us = lista_us;
    }

    public OpcionUsuario getUs_op() {
        return us_op;
    }

    public void setUs_op(OpcionUsuario us_op) {
        this.us_op = us_op;
    }

    public List<Opcion> getListaSeleccionada() {
        return listaSeleccionada;
    }

    public void setListaSeleccionada(List<Opcion> listaSeleccionada) {
        this.listaSeleccionada = listaSeleccionada;
    }

    public Opcion getOpcionSelecionada() {
        return opcionSelecionada;
    }

    public void setOpcionSelecionada(Opcion opcionSelecionada) {
        this.opcionSelecionada = opcionSelecionada;
    }

    public List<Opcion> getLista() {
        return lista;
    }

    public void setLista(List<Opcion> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        opcion = new Opcion();
        this.listarOpciones();
        model = new DefaultMenuModel();
        this.establecerPermisos();
        lista_us = EJB_us_op.findAll();

    }

    public void listarOpciones() {
        try {
            lista = EJBOpcion.findAll();
        } catch (Exception e) {
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

//&& usuario.getIdUsuario().equals(us.getIdUsuario() )
    public void establecerPermisos() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

        for (Opcion m : lista) {
            if (m.getCtrMenus() == 1) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getDesOpcion());
                for (Opcion a : lista) {
                    Opcion submenu = a.getIdPadre();
                    if (submenu != null) {
                        if (submenu.getIdOpcion().equals(m.getIdOpcion())) {

                            DefaultSubMenu SecondSubmenu = new DefaultSubMenu(a.getDesOpcion());

                            for (Opcion i : lista) {

                                Opcion submenu_2 = i.getIdPadre();
                                if (submenu_2 != null) {
                                    if (submenu_2.getIdOpcion().equals(a.getIdOpcion())) {

                                        DefaultMenuItem item = new DefaultMenuItem(i.getDesOpcion());
                                        item.setUrl(i.getLnkOpcion());
                                        item.setIcon("ui-icon-home");
                                        SecondSubmenu.addElement(item);

                                    }

                                }

                            }

                            firstSubmenu.addElement(SecondSubmenu);

                        }
                    }
                }
                model.addElement(firstSubmenu);

            }

        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String mostrarUsuarioLogeado() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getNomUsuario();
    }

    public void registar() {
        try {

            EJBOpcion.create(opcion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso ", "Se Registro"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso error", "Error"));
            System.out.println("com.avisora.controller.OpcionController.registar()" + e);
        }

    }

    public void modificarMenu() {

        if (opcionSelecionada != null) {
            setOpcion(opcionSelecionada);

        } else {

        }

    }

    public void eliminarMenu() {
        if (opcionSelecionada != null) {

            EJBOpcion.remove(opcionSelecionada);

        } else {

        }
        resetearFormularioM();
        init();
    }

    public void GuardarActualizarM() {
        FacesMessage mensaje = new FacesMessage();
        try {
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
            if (opcionSelecionada != null) {
                EJBOpcion.edit(opcion);

            } else {
                EJBOpcion.create(opcion);
            }
            resetearFormularioM();
            init();

        } catch (Exception e) {

            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
        }

    }

    public void update() {
        try {
            System.out.println("estoy aki");

            EJBOpcion.edit(opcion);

        } catch (Exception e) {
            System.out.println("com.avisora.controller.UsuarioController.update() error" + e);
        }

        resetearFormularioM();
        init();

    }

    public void resetearFormularioM() {
        this.opcion = new Opcion();
        this.opcionSelecionada = null;
    }

    public void SelecionOpcion(SelectEvent event) {
        opcionSelecionada = (Opcion) event.getObject();

    }

    public void usuarioAsignado() {
        for (Opcion a : lista) {

            System.out.println("as" + a);
            for (OpcionUsuario b : lista_us) {

                System.out.println("as :" + b);

            }

        }

    }

    public void menuAsignado() {

        
        for (Opcion a : lista) {
           

            for (OpcionUsuario b : lista_us) {
                if (a.getIdOpcion().equals(b.getIdOpcion())) {
                    a.getIdOpcion();
                    a.getDesOpcion();
                    a.getOpcionCollection();
                    
                    System.out.println("Lista usuario con asignacion"+ a);

                }
            }

        }

    }

}
