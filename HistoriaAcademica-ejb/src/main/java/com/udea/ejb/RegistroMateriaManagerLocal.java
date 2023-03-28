/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Registromateria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mario
 */
@Local
public interface RegistroMateriaManagerLocal {

    List<Registromateria> getRegistrosMaterias();
    
}
