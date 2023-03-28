/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Historiaacademica;
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
public class HistoriaacademicaManager implements HistoriaacademicaManagerLocal {

    @PersistenceContext(unitName = "com.udea_HistoriaAcademica-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Historiaacademica> getHistoriasAcademicas() {
        Query query = em.createNamedQuery("Historiaacademica.findAll");
        return query.getResultList();
    }
    
    
}
