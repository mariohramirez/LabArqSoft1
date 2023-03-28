/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "registromateria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registromateria.findAll", query = "SELECT r FROM Registromateria r")
    , @NamedQuery(name = "Registromateria.findByRegistroID", query = "SELECT r FROM Registromateria r WHERE r.registroID = :registroID")
    , @NamedQuery(name = "Registromateria.findByEstado", query = "SELECT r FROM Registromateria r WHERE r.estado = :estado")})
public class Registromateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegistroID")
    private Integer registroID;
    @Size(max = 10)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "HistoriaIDRegistro", referencedColumnName = "HistoriaID")
    @ManyToOne
    private Historiaacademica historiaIDRegistro;
    @JoinColumn(name = "MateriaIDRegistro", referencedColumnName = "MateriaID")
    @ManyToOne
    private Materia materiaIDRegistro;

    public Registromateria() {
    }

    public Registromateria(Integer registroID) {
        this.registroID = registroID;
    }

    public Integer getRegistroID() {
        return registroID;
    }

    public void setRegistroID(Integer registroID) {
        this.registroID = registroID;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Historiaacademica getHistoriaIDRegistro() {
        return historiaIDRegistro;
    }

    public void setHistoriaIDRegistro(Historiaacademica historiaIDRegistro) {
        this.historiaIDRegistro = historiaIDRegistro;
    }

    public Materia getMateriaIDRegistro() {
        return materiaIDRegistro;
    }

    public void setMateriaIDRegistro(Materia materiaIDRegistro) {
        this.materiaIDRegistro = materiaIDRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroID != null ? registroID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registromateria)) {
            return false;
        }
        Registromateria other = (Registromateria) object;
        if ((this.registroID == null && other.registroID != null) || (this.registroID != null && !this.registroID.equals(other.registroID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Registromateria[ registroID=" + registroID + " ]";
    }
    
}
