/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.controller;


import aduana.modelo.Formularioarancelario;
import aduana.service.FormArancelarioService;
import aduana.service.FormArancelarioServiceImpl;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
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
<<<<<<< HEAD
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
=======

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
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
    }
 
 
    
    //-------------------Retrieve Single FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formularioarancelario> getUser(@PathVariable("id") int id) {
        System.out.println("Buscando el usuario " + id);
<<<<<<< HEAD
        Formularioarancelario formAran = formArancelarioService.findById(id);
=======
        Formularioarancelario formAran = servicioArancelario.findById(id);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        if (formAran == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Formularioarancelario>(formAran, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a FormularioArancelario--------------------------------------------------------
     
<<<<<<< HEAD
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
=======
    @RequestMapping(value = "/FA/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Formularioarancelario formAran,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creando formulario " + formAran.getIdFormarancelario());
 
         
        servicioArancelario.saveFormularioArancelario(formAran);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/FA/{id}").buildAndExpand(formAran.getIdFormarancelario()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
    }
 
    
     
    //------------------- Update a FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.PUT)
<<<<<<< HEAD
    public ResponseEntity<Formularioarancelario> updateFormularioArancelario(@PathVariable("id") int id, @RequestBody Formularioarancelario formAran) {
        System.out.println("Actualizando formulario " + id);
         
        Formularioarancelario currentArancel = formArancelarioService.findById(id);
=======
    public ResponseEntity<Formularioarancelario> updateUser(@PathVariable("id") int id, @RequestBody Formularioarancelario formAran) {
        System.out.println("Actualizando formulario " + id);
         
        Formularioarancelario currentArancel = servicioArancelario.findById(id);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
         
        if (currentArancel==null) {
            System.out.println("formulario con " + id + " no se encuentra");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
 
<<<<<<< HEAD
        currentArancel.setCodarancelarioFa(formAran.getCodarancelarioFa());
        currentArancel.setProducto(formAran.getProducto());
        currentArancel.setUsuario(formAran.getUsuario());
         
        formArancelarioService.updateFormularioArancelario(currentArancel);
=======
        currentArancel.setCodarancelarioFormarancelario(formAran.getCodarancelarioFormarancelario());
        currentArancel.setProductos(formAran.getProductos());
        currentArancel.setUsuario(formAran.getUsuario());
         
        servicioArancelario.updateFormularioArancelario(currentArancel);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        return new ResponseEntity<Formularioarancelario>(currentArancel, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FA/{id}", method = RequestMethod.DELETE)
<<<<<<< HEAD
    public ResponseEntity<Formularioarancelario> deleteFormularioArancelarioById(@PathVariable("id") int id) {
        System.out.println("eliminar formulario " + id);
 
        Formularioarancelario fa = formArancelarioService.findById(id);
        if (fa == null) {
            System.out.println("No se puede eliminar el formulario " + id + " no se encontro");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
 
        formArancelarioService.deleteFormularioArancelarioById(id);
=======
    public ResponseEntity<Formularioarancelario> deleteUser(@PathVariable("id") int id) {
        System.out.println("eliminar formulario " + id);
 
        Formularioarancelario user = servicioArancelario.findById(id);
        if (user == null) {
            System.out.println("no se puede eliminar el formulario " + id + " not found");
            return new ResponseEntity<Formularioarancelario>(HttpStatus.NOT_FOUND);
        }
        
        Formularioarancelario fa = servicioArancelario.findById(id);
        
        servicioArancelario.deleteFormularioArancelarioById(fa);
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        return new ResponseEntity<Formularioarancelario>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FA/", method = RequestMethod.DELETE)
<<<<<<< HEAD
    public ResponseEntity<Formularioarancelario> deleteAllFormularioArancelario() {
        System.out.println("Borrando Todos los Formularios Arancelarios");
 
        formArancelarioService.deleteAllFormularioArancelario();
=======
    public ResponseEntity<Formularioarancelario> deleteAllUsers() {
        System.out.println("Deleting All formularios arancelarios");
 
        servicioArancelario.deleteAllFormularioArancelario();
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        return new ResponseEntity<Formularioarancelario>(HttpStatus.NO_CONTENT);
    }
    

}
