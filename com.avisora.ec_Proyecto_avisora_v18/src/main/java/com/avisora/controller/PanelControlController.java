/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author avmei
 */
@Named
@ViewScoped
public class PanelControlController implements Serializable {

    private boolean ocultar = false;
    private boolean habilitado = true;

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
    
    

}
