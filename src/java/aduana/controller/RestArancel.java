/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.controller;


import aduana.modelo.Formularioarancelario;
import aduana.service.FormArancelarioService;
import aduana.service.FormArancelarioServiceImpl;
import java.util.ArrayList;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RestArancel {
    
    FormArancelarioService formArancelarioService ;  //Service which will do all data retrieval/manipulation work
 
    
        //-------------------Retrieve All FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Formularioarancelario>> listAllFormularioArancelario() {
        List<Formularioarancelario> formAran = new ArrayList();
        try{
        formAran = formArancelarioService.findAllFormularioArancelario();
        }catch(Exception e) {
            System.out.println("bloque de código donde se trata el problema");
        }
        
        if(formAran.isEmpty()){
            return new ResponseEntity<List<Formularioarancelario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        else {HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setLocation(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand("120")
                    .toUri());
        return new ResponseEntity<List<Formularioarancelario>>(httpHeaders , HttpStatus.OK);
        }
    }
 
 
    
    //-------------------Retrieve Single FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formularioarancelario> getUser(@PathVariable("id") int id) {
        System.out.println("Buscando el usuario " + id);
        Formularioarancelario formAran = formArancelarioService.findById(id);
        if (formAran == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Formularioarancelario>(formAran, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a FormularioArancelario--------------------------------------------------------
     
   @RequestMapping(value = "/FA", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveFormularioArancelario(@RequestBody Formularioarancelario formArancelario,    UriComponentsBuilder ucBuilder) {

        System.out.println("entro al metodo de guardado");
        
        //formArancelarioService.saveFormularioArancelario(formArancelario);
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.setLocation(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand("120")
                    .toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Formularioarancelario> updateFormularioArancelario(@PathVariable("id") int id, @RequestBody Formularioarancelario formAran) {
        System.out.println("Actualizando formulario " + id);
         
        Formularioarancelario currentArancel = formArancelarioService.findById(id);
         
        if (currentArancel==null) {
            System.out.println("formulario con " + id + " no se encuentra");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
 
        currentArancel.setCodarancelarioFa(formAran.getCodarancelarioFa());
        currentArancel.setProducto(formAran.getProducto());
        currentArancel.setUsuario(formAran.getUsuario());
         
        formArancelarioService.updateFormularioArancelario(currentArancel);
        return new ResponseEntity<Formularioarancelario>(currentArancel, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Formularioarancelario> deleteFormularioArancelarioById(@PathVariable("id") int id) {
        System.out.println("eliminar formulario " + id);
 
        Formularioarancelario fa = formArancelarioService.findById(id);
        if (fa == null) {
            System.out.println("No se puede eliminar el formulario " + id + " no se encontro");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
 
        formArancelarioService.deleteFormularioArancelarioById(id);
        return new ResponseEntity<Formularioarancelario>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FA/", method = RequestMethod.DELETE)
    public ResponseEntity<Formularioarancelario> deleteAllFormularioArancelario() {
        System.out.println("Borrando Todos los Formularios Arancelarios");
 
        formArancelarioService.deleteAllFormularioArancelario();
        return new ResponseEntity<Formularioarancelario>(HttpStatus.NO_CONTENT);
    }
    

}
