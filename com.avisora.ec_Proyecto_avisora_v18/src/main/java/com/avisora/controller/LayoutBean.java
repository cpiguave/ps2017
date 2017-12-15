/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;




@ManagedBean(name = "LayoutBean", eager = true)
@ApplicationScoped
public class LayoutBean {

    private String theme = "redmond";

    public String getApplicationTheme() {
        return theme;
    }
}