/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "historiaacademica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiaacademica.findAll", query = "SELECT h FROM Historiaacademica h")
    , @NamedQuery(name = "Historiaacademica.findByHistoriaID", query = "SELECT h FROM Historiaacademica h WHERE h.historiaID = :historiaID")})
public class Historiaacademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HistoriaID")
    private Integer historiaID;
    @JoinColumn(name = "EstudianteID", referencedColumnName = "EstudianteID")
    @ManyToOne
    private Estudiante estudianteID;
    @JoinColumn(name = "PlanID", referencedColumnName = "PlanID")
    @ManyToOne
    private Planestudios planID;
    @OneToMany(mappedBy = "historiaIDRegistro")
    private Collection<Registromateria> registromateriaCollection;

    public Historiaacademica() {
    }

    public Historiaacademica(Integer historiaID) {
        this.historiaID = historiaID;
    }

    public Integer getHistoriaID() {
        return historiaID;
    }

    public void setHistoriaID(Integer historiaID) {
        this.historiaID = historiaID;
    }

    public Estudiante getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(Estudiante estudianteID) {
        this.estudianteID = estudianteID;
    }

    public Planestudios getPlanID() {
        return planID;
    }

    public void setPlanID(Planestudios planID) {
        this.planID = planID;
    }

    @XmlTransient
    public Collection<Registromateria> getRegistromateriaCollection() {
        return registromateriaCollection;
    }

    public void setRegistromateriaCollection(Collection<Registromateria> registromateriaCollection) {
        this.registromateriaCollection = registromateriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historiaID != null ? historiaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiaacademica)) {
            return false;
        }
        Historiaacademica other = (Historiaacademica) object;
        if ((this.historiaID == null && other.historiaID != null) || (this.historiaID != null && !this.historiaID.equals(other.historiaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Historiaacademica[ historiaID=" + historiaID + " ]";
    }
    
}
