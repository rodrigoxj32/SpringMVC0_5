/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

import aduana.modelo.Formularioexportacion;
import java.util.List;

public interface FormExportacionService {
	
	Formularioexportacion findById(int id);
		
	void saveFormularioExportacion(Formularioexportacion fe);
	
	void updateFormularioExportacion(Formularioexportacion fe);
	
	void deleteFormularioExportacionById(Formularioexportacion fe);

	List<Formularioexportacion> findAllFormExportacion(); 
	
	void deleteAllFormularioexportacion();
	

	
}