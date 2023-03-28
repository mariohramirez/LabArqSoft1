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
@Table(name = "planestudios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planestudios.findAll", query = "SELECT p FROM Planestudios p")
    , @NamedQuery(name = "Planestudios.findByPlanID", query = "SELECT p FROM Planestudios p WHERE p.planID = :planID")
    , @NamedQuery(name = "Planestudios.findByProgramaID", query = "SELECT p FROM Planestudios p WHERE p.programaID = :programaID")
    , @NamedQuery(name = "Planestudios.findByFacultadID", query = "SELECT p FROM Planestudios p WHERE p.facultadID = :facultadID")})
public class Planestudios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PlanID")
    private Integer planID;
    @Column(name = "ProgramaID")
    private Integer programaID;
    @Column(name = "FacultadID")
    private Integer facultadID;
    @OneToMany(mappedBy = "planID")
    private Collection<Historiaacademica> historiaacademicaCollection;
    @OneToMany(mappedBy = "planIDMateria")
    private Collection<Materia> materiaCollection;

    public Planestudios() {
    }

    public Planestudios(Integer planID) {
        this.planID = planID;
    }

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public Integer getProgramaID() {
        return programaID;
    }

    public void setProgramaID(Integer programaID) {
        this.programaID = programaID;
    }

    public Integer getFacultadID() {
        return facultadID;
    }

    public void setFacultadID(Integer facultadID) {
        this.facultadID = facultadID;
    }

    @XmlTransient
    public Collection<Historiaacademica> getHistoriaacademicaCollection() {
        return historiaacademicaCollection;
    }

    public void setHistoriaacademicaCollection(Collection<Historiaacademica> historiaacademicaCollection) {
        this.historiaacademicaCollection = historiaacademicaCollection;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planID != null ? planID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planestudios)) {
            return false;
        }
        Planestudios other = (Planestudios) object;
        if ((this.planID == null && other.planID != null) || (this.planID != null && !this.planID.equals(other.planID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Planestudios[ planID=" + planID + " ]";
    }
    
}
