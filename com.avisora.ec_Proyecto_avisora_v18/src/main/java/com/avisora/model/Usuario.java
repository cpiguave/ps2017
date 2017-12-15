/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avisora.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author avmei
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNomUsuario", query = "SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "Usuario.findByCtrHabilitado", query = "SELECT u FROM Usuario u WHERE u.ctrHabilitado = :ctrHabilitado")
    , @NamedQuery(name = "Usuario.findByPwdUsuario", query = "SELECT u FROM Usuario u WHERE u.pwdUsuario = :pwdUsuario")
    , @NamedQuery(name = "Usuario.findByFecRegistro", query = "SELECT u FROM Usuario u WHERE u.fecRegistro = :fecRegistro")
    , @NamedQuery(name = "Usuario.findByFecAucpwd", query = "SELECT u FROM Usuario u WHERE u.fecAucpwd = :fecAucpwd")
    , @NamedQuery(name = "Usuario.findByDiaActpwd", query = "SELECT u FROM Usuario u WHERE u.diaActpwd = :diaActpwd")
    , @NamedQuery(name = "Usuario.findByDirElectronica", query = "SELECT u FROM Usuario u WHERE u.dirElectronica = :dirElectronica")
    , @NamedQuery(name = "Usuario.findByTlfCelular", query = "SELECT u FROM Usuario u WHERE u.tlfCelular = :tlfCelular")
    , @NamedQuery(name = "Usuario.findByAdmUsuario", query = "SELECT u FROM Usuario u WHERE u.admUsuario = :admUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nom_usuario")
    private String nomUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ctr_habilitado")
    private short ctrHabilitado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pwd_usuario")
    private String pwdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    private Date fecRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_aucpwd")
    @Temporal(TemporalType.DATE)
    private Date fecAucpwd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dia_actpwd")
    private short diaActpwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dir_electronica")
    private String dirElectronica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tlf_celular")
    private String tlfCelular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adm_usuario")
    private short admUsuario;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<OpcionUsuario> opcionUsuarioCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nomUsuario, short ctrHabilitado, String pwdUsuario, Date fecRegistro, Date fecAucpwd, short diaActpwd, String dirElectronica, String tlfCelular, short admUsuario) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.ctrHabilitado = ctrHabilitado;
        this.pwdUsuario = pwdUsuario;
        this.fecRegistro = fecRegistro;
        this.fecAucpwd = fecAucpwd;
        this.diaActpwd = diaActpwd;
        this.dirElectronica = dirElectronica;
        this.tlfCelular = tlfCelular;
        this.admUsuario = admUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public short getCtrHabilitado() {
        return ctrHabilitado;
    }

    public void setCtrHabilitado(short ctrHabilitado) {
        this.ctrHabilitado = ctrHabilitado;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public Date getFecAucpwd() {
        return fecAucpwd;
    }

    public void setFecAucpwd(Date fecAucpwd) {
        this.fecAucpwd = fecAucpwd;
    }

    public short getDiaActpwd() {
        return diaActpwd;
    }

    public void setDiaActpwd(short diaActpwd) {
        this.diaActpwd = diaActpwd;
    }

    public String getDirElectronica() {
        return dirElectronica;
    }

    public void setDirElectronica(String dirElectronica) {
        this.dirElectronica = dirElectronica;
    }

    public String getTlfCelular() {
        return tlfCelular;
    }

    public void setTlfCelular(String tlfCelular) {
        this.tlfCelular = tlfCelular;
    }

    public short getAdmUsuario() {
        return admUsuario;
    }

    public void setAdmUsuario(short admUsuario) {
        this.admUsuario = admUsuario;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.avisora.model.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    public void setCtrHabilitado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String setNomUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
