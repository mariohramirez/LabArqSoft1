/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Estudiante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mario
 */
@Stateless
public class EstudianteManager implements EstudianteManagerLocal {

    @PersistenceContext(unitName = "com.udea_HistoriaAcademica-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Estudiante> getAllEstudiantes() {
        Query query = em.createNamedQuery("Estudiante.findAll");
        return query.getResultList();
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        return em.merge(estudiante);
    }
    
    
    
}
