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
        
        Formularioarancelario findById(int id);
		
	void saveFormularioArancelario(Formularioarancelario fa);
	
	void updateFormularioArancelario(Formularioarancelario fa);
	
<<<<<<< HEAD
	void deleteFormularioArancelarioById(int fa);
=======
	void deleteFormularioArancelarioById(Formularioarancelario fa);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3

	List<Formularioarancelario> findAllFormularioArancelario(); 
	
	void deleteAllFormularioArancelario();
    
}
