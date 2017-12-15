/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.criteria.Order;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author avmei
 */
@Entity
@Table(name = "opcion_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionUsuario.findAll", query = "SELECT o FROM OpcionUsuario o")
    , @NamedQuery(name = "OpcionUsuario.findByIdOpUs", query = "SELECT o FROM OpcionUsuario o WHERE o.idOpUs = :idOpUs")
    , @NamedQuery(name = "OpcionUsuario.usuopcion", query = "SELECT o FROM OpcionUsuario o  WHERE o.idUsuario = :idUsuarioP")
})
public class OpcionUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_op_us")
    private Integer idOpUs;
    @JoinColumn(name = "id_opcion", referencedColumnName = "id_opcion")
    @ManyToOne
    private Opcion idOpcion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;

    public OpcionUsuario() {
    }

    public OpcionUsuario(Integer idOpUs) {
        this.idOpUs = idOpUs;
    }

    public Integer getIdOpUs() {
        return idOpUs;
    }

    public void setIdOpUs(Integer idOpUs) {
        this.idOpUs = idOpUs;
    }

    public Opcion getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Opcion idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpUs != null ? idOpUs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionUsuario)) {
            return false;
        }
        OpcionUsuario other = (OpcionUsuario) object;
        if ((this.idOpUs == null && other.idOpUs != null) || (this.idOpUs != null && !this.idOpUs.equals(other.idOpUs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avisora.model.OpcionUsuario[ idOpUs=" + idOpUs + " ]";
    }
    
  
    

}
