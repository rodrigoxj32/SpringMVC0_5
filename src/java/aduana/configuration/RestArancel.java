/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.configuration;


import aduana.modelo.Formularioarancelario;
import aduana.service.FormArancelarioService;
import aduana.service.FormArancelarioServiceImpl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.stereotype.Controller;

@RestController
public class RestArancel {
    @Autowired( required = false)
    FormArancelarioService servicioArancelario ;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/", method = RequestMethod.GET)
    public ResponseEntity<List<Formularioarancelario>> listAllUsers() {
        System.out.println("metodo de busqueda");
        List<Formularioarancelario> formAran = servicioArancelario.findAllFormularioArancelario();
        if(formAran.isEmpty()){
            return new ResponseEntity<List<Formularioarancelario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Formularioarancelario>>(formAran, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formularioarancelario> getUser(@PathVariable("id") int id) {
        System.out.println("Buscando el usuario " + id);
        Formularioarancelario formAran = servicioArancelario.findById(id);
        if (formAran == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Formularioarancelario>(formAran, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Formularioarancelario formAran,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creando formulario " + formAran.getIdFormarancelario());
 
         
        servicioArancelario.saveFormularioArancelario(formAran);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/FA/{id}").buildAndExpand(formAran.getIdFormarancelario()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Formularioarancelario> updateUser(@PathVariable("id") int id, @RequestBody Formularioarancelario formAran) {
        System.out.println("Actualizando formulario " + id);
         
        Formularioarancelario currentArancel = servicioArancelario.findById(id);
         
        if (currentArancel==null) {
            System.out.println("formulario con " + id + " no se encuentra");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
 
        currentArancel.setCodarancelarioFormarancelario(formAran.getCodarancelarioFormarancelario());
        currentArancel.setProductos(formAran.getProductos());
        currentArancel.setUsuario(formAran.getUsuario());
         
        servicioArancelario.updateFormularioArancelario(currentArancel);
        return new ResponseEntity<Formularioarancelario>(currentArancel, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Formularioarancelario> deleteUser(@PathVariable("id") int id) {
        System.out.println("eliminar formulario " + id);
 
        Formularioarancelario user = servicioArancelario.findById(id);
        if (user == null) {
            System.out.println("no se puede eliminar el formulario " + id + " not found");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
        
        Formularioarancelario fa = servicioArancelario.findById(id);
        
        servicioArancelario.deleteFormularioArancelarioById(fa);
        return new ResponseEntity<Formularioarancelario>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FA/", method = RequestMethod.DELETE)
    public ResponseEntity<Formularioarancelario> deleteAllUsers() {
        System.out.println("Deleting All formularios arancelarios");
 
        servicioArancelario.deleteAllFormularioArancelario();
        return new ResponseEntity<Formularioarancelario>(HttpStatus.NO_CONTENT);
    }
    

}
