/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

/**
 *
 * @author Rodrigo Daniel
 */

import org.springframework.stereotype.Service;
 
import aduana.modelo.Formularioexportacion;
import java.util.List;
 
@Service("formExportacionService")
public class FormExportacionServiceImpl implements FormExportacionService {

    @Override
    public Formularioexportacion findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveFormularioExportacion(Formularioexportacion user) {
        
            /*codigo para guardar en la base*/
        System.out.println("algo paso");
    }

    @Override
    public void updateFormularioExportacion(Formularioexportacion user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFormularioExportacionById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formularioexportacion> findAllFormExportacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllFormularioexportacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
