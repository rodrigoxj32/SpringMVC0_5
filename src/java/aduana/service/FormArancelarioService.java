/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

import aduana.modelo.Formularioarancelario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonathan
 */
public interface FormArancelarioService {
        Formularioarancelario findById(long id);
		
	void saveFormularioArancelario(Formularioarancelario fa);
	
	void updateFormularioArancelario(Formularioarancelario fa);
	
	void deleteFormularioArancelarioById(long id);

	List<Formularioarancelario> findAllFormularioArancelario(); 
	
	void deleteAllFormularioArancelario();
    
}
