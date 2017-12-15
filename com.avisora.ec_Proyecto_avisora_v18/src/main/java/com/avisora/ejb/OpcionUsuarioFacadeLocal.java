/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.ejb;

import com.avisora.model.OpcionUsuario;
import com.avisora.model.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author avmei
 */
@Local
public interface OpcionUsuarioFacadeLocal {

    void create(OpcionUsuario opcionUsuario);

    void edit(OpcionUsuario opcionUsuario);

    void remove(OpcionUsuario opcionUsuario);

    OpcionUsuario find(Object id);

    List<OpcionUsuario> findAll();

    List<OpcionUsuario> findRange(int[] range);

    int count();
    

    
}
