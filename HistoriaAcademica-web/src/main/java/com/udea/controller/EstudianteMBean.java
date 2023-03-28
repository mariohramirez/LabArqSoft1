/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.HistoriaacademicaManagerLocal;
import com.udea.ejb.MateriaManagerLocal;
import com.udea.ejb.PlanEstudioManagerLocal;
import com.udea.ejb.RegistroMateriaManagerLocal;
import com.udea.modelo.Estudiante;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Mario
 */
public class EstudianteMBean implements Serializable {

    @EJB
    private RegistroMateriaManagerLocal registroMateriaManager;

    @EJB
    private PlanEstudioManagerLocal planEstudioManager;

    @EJB
    private MateriaManagerLocal materiaManager;

    @EJB
    private HistoriaacademicaManagerLocal historiaacademicaManager;

    @EJB
    private com.udea.ejb.EstudianteManagerLocal estudianteManager;
    
    //Propiedades del modelo
    
    private Estudiante estudiante;//Para mostrar, actualizar o insertar en el formulario
    private List<Estudiante> estudiantes;   //Para visualizar en la tabla
    
    /**
     * Creates a new instance of EstudianteMBean
     */
    public EstudianteMBean() {
    }
    
    //Método para retornar una lista de estudiantes para mostrar en el data table
    public List<Estudiante> getEstudiantes()
    {
        if((estudiantes==null)||(estudiantes.isEmpty()))
                refresh();
        return estudiantes;
    }
    
    //Retorne el detalle de cada estudiante en el formulario
    public Estudiante getDetails()
    {        
        return estudiante;
    }
    
    //Action Handler
    //Es llamado cuando en una fila de la tabla se haga click en el id
    public String showDetails(Estudiante estudiante){
        this.estudiante = estudiante;
        return "DETAILS";
    }
    
    //Action Handler
    //Actualiza el modelo estudiante en la base de datos y se llama cuando
    //se presiona el botón Update del formulario
    public String update(){
        estudiante = estudianteManager.update(estudiante);
        return "SAVED";
    }
    
    //Action Handler
    //Retorna a la lista de estudiantes
    public String list(){
        return "LIST";
    }
    
    public void refresh(){
        estudiantes=estudianteManager.getAllEstudiantes();
    }
    
}