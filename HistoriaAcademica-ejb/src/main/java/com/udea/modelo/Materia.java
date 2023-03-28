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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByMateriaID", query = "SELECT m FROM Materia m WHERE m.materiaID = :materiaID")
    , @NamedQuery(name = "Materia.findByNombreMateria", query = "SELECT m FROM Materia m WHERE m.nombreMateria = :nombreMateria")
    , @NamedQuery(name = "Materia.findByTipoMateria", query = "SELECT m FROM Materia m WHERE m.tipoMateria = :tipoMateria")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MateriaID")
    private Integer materiaID;
    @Size(max = 20)
    @Column(name = "NombreMateria")
    private String nombreMateria;
    @Size(max = 20)
    @Column(name = "TipoMateria")
    private String tipoMateria;
    @JoinColumn(name = "PlanIDMateria", referencedColumnName = "PlanID")
    @ManyToOne
    private Planestudios planIDMateria;
    @OneToMany(mappedBy = "materiaIDRegistro")
    private Collection<Registromateria> registromateriaCollection;

    public Materia() {
    }

    public Materia(Integer materiaID) {
        this.materiaID = materiaID;
    }

    public Integer getMateriaID() {
        return materiaID;
    }

    public void setMateriaID(Integer materiaID) {
        this.materiaID = materiaID;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(String tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    public Planestudios getPlanIDMateria() {
        return planIDMateria;
    }

    public void setPlanIDMateria(Planestudios planIDMateria) {
        this.planIDMateria = planIDMateria;
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
        hash += (materiaID != null ? materiaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.materiaID == null && other.materiaID != null) || (this.materiaID != null && !this.materiaID.equals(other.materiaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Materia[ materiaID=" + materiaID + " ]";
    }
    
}
