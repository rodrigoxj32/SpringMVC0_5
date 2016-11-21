/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

import aduana.modelo.Formularioexportacion;
import java.util.List;

public interface FormExportacionService {
	
	Formularioexportacion findById(long id);
		
	void saveFormularioExportacion(Formularioexportacion user);
	
	void updateFormularioExportacion(Formularioexportacion user);
	
	void deleteFormularioExportacionById(long id);

	List<Formularioexportacion> findAllFormExportacion(); 
	
	void deleteAllFormularioexportacion();
	

	
}