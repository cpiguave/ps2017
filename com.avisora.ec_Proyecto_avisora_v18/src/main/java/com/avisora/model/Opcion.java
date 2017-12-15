/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author avmei
 */
@Entity
@Table(name = "opcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
    , @NamedQuery(name = "Opcion.findByIdOpcion", query = "SELECT o FROM Opcion o WHERE o.idOpcion = :idOpcion")
    , @NamedQuery(name = "Opcion.findByDesOpcion", query = "SELECT o FROM Opcion o WHERE o.desOpcion = :desOpcion")
    , @NamedQuery(name = "Opcion.findByLnkOpcion", query = "SELECT o FROM Opcion o WHERE o.lnkOpcion = :lnkOpcion")
    , @NamedQuery(name = "Opcion.findByCtrMenus", query = "SELECT o FROM Opcion o WHERE o.ctrMenus = :ctrMenus")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_opcion")
    private String idOpcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "des_opcion")
    private String desOpcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lnk_opcion")
    private String lnkOpcion;
    @Column(name = "ctr_menus")
    private Integer ctrMenus;
    @OneToMany(mappedBy = "idPadre")
    private Collection<Opcion> opcionCollection;
    @JoinColumn(name = "id_padre", referencedColumnName = "id_opcion")
    @ManyToOne
    private Opcion idPadre;
    @OneToMany(mappedBy = "idOpcion")
    private Collection<OpcionUsuario> opcionUsuarioCollection;

    public Opcion() {
    }

    public Opcion(String idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Opcion(String idOpcion, String desOpcion, String lnkOpcion) {
        this.idOpcion = idOpcion;
        this.desOpcion = desOpcion;
        this.lnkOpcion = lnkOpcion;
    }

    public String getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(String idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDesOpcion() {
        return desOpcion;
    }

    public void setDesOpcion(String desOpcion) {
        this.desOpcion = desOpcion;
    }

    public String getLnkOpcion() {
        return lnkOpcion;
    }

    public void setLnkOpcion(String lnkOpcion) {
        this.lnkOpcion = lnkOpcion;
    }

    public Integer getCtrMenus() {
        return ctrMenus;
    }

    public void setCtrMenus(Integer ctrMenus) {
        this.ctrMenus = ctrMenus;
    }

    @XmlTransient
    public Collection<Opcion> getOpcionCollection() {
        return opcionCollection;
    }

    public void setOpcionCollection(Collection<Opcion> opcionCollection) {
        this.opcionCollection = opcionCollection;
    }

    public Opcion getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Opcion idPadre) {
        this.idPadre = idPadre;
    }

    @XmlTransient
    public Collection<OpcionUsuario> getOpcionUsuarioCollection() {
        return opcionUsuarioCollection;
    }

    public void setOpcionUsuarioCollection(Collection<OpcionUsuario> opcionUsuarioCollection) {
        this.opcionUsuarioCollection = opcionUsuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avisora.model.Opcion[ idOpcion=" + idOpcion + " ]";
    }

    public Object agetIdOpcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setIdOpcion(SingularAttribute<OpcionUsuario, Opcion> idOpcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
