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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByEstudianteID", query = "SELECT e FROM Estudiante e WHERE e.estudianteID = :estudianteID")
    , @NamedQuery(name = "Estudiante.findByNombreEstudiante", query = "SELECT e FROM Estudiante e WHERE e.nombreEstudiante = :nombreEstudiante")
    , @NamedQuery(name = "Estudiante.findByEmail", query = "SELECT e FROM Estudiante e WHERE e.email = :email")
    , @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstudianteID")
    private Integer estudianteID;
    @Size(max = 50)
    @Column(name = "NombreEstudiante")
    private String nombreEstudiante;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "Email")
    private String email;
    @Size(max = 10)
    @Column(name = "Telefono")
    private String telefono;
    @OneToMany(mappedBy = "estudianteID")
    private Collection<Historiaacademica> historiaacademicaCollection;

    public Estudiante() {
    }

    public Estudiante(Integer estudianteID) {
        this.estudianteID = estudianteID;
    }

    public Integer getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(Integer estudianteID) {
        this.estudianteID = estudianteID;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Historiaacademica> getHistoriaacademicaCollection() {
        return historiaacademicaCollection;
    }

    public void setHistoriaacademicaCollection(Collection<Historiaacademica> historiaacademicaCollection) {
        this.historiaacademicaCollection = historiaacademicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteID != null ? estudianteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudianteID == null && other.estudianteID != null) || (this.estudianteID != null && !this.estudianteID.equals(other.estudianteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Estudiante[ estudianteID=" + estudianteID + " ]";
    }
    
}
