/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.configuration;
import aduana.modelo.Formularioexportacion;
import aduana.service.FormExportacionService;
import aduana.service.FormExportacionServiceImpl;
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
public class RestExportacion {
    @Autowired( required = false)
    FormExportacionService servicioExportacion;
    
        
    //-------------------Retrieve All FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FE/", method = RequestMethod.GET)
    public ResponseEntity<List<Formularioexportacion>> listAllUsers() {
        System.out.println("metodo de busqueda exportacion");
        List<Formularioexportacion> formAran = servicioExportacion.findAllFormExportacion();
        if(formAran.isEmpty()){
            return new ResponseEntity<List<Formularioexportacion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Formularioexportacion>>(formAran, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FE/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Formularioexportacion> getUser(@PathVariable("id") int id) {
        System.out.println("Buscando el formulario exportacion" + id);
        Formularioexportacion formAran = servicioExportacion.findById(id);
        if (formAran == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Formularioexportacion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Formularioexportacion>(formAran, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FE/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Formularioexportacion formAran,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creando formulario exportacion " + formAran.getIdFormexpor());
 
         
        servicioExportacion.saveFormularioExportacion(formAran);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/FE/{id}").buildAndExpand(formAran.getIdFormexpor()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a FormularioArancelario--------------------------------------------------------
     
    @RequestMapping(value = "/FE/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Formularioexportacion> updateUser(@PathVariable("id") int id, @RequestBody Formularioexportacion formExport) {
        System.out.println("Actualizando formulario exportacion " + id);
         
        Formularioexportacion currentExportacion = servicioExportacion.findById(id);
         
        if (currentExportacion==null) {
            System.out.println("formulario con " + id + " no se encuentra");
            return new ResponseEntity<Formularioexportacion>(HttpStatus.NOT_FOUND);
        }
 
        currentExportacion.setCodigoFormexpor(formExport.getCodigoFormexpor());
        currentExportacion.setFechaFormexpor(formExport.getFechaFormexpor());
        currentExportacion.setInstanciasFormexpor(formExport.getInstanciasFormexpor());
        currentExportacion.setObservacionesFormexpor(formExport.getObservacionesFormexpor());
        currentExportacion.setOrigenFormexpor(formExport.getOrigenFormexpor());
        currentExportacion.setPaises(formExport.getPaises());
        currentExportacion.setTransporte(formExport.getTransporte());
        currentExportacion.setUsuario(formExport.getUsuario());
         
        servicioExportacion.updateFormularioExportacion(currentExportacion);
        return new ResponseEntity<Formularioexportacion>(currentExportacion, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FE/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Formularioexportacion> deleteUser(@PathVariable("id") int id) {
        System.out.println("eliminar formulario exportacion " + id);
 
        Formularioexportacion user = servicioExportacion.findById(id);
        if (user == null) {
            System.out.println("no se puede eliminar el formulario " + id + " not found");
            return new ResponseEntity<Formularioexportacion>(HttpStatus.NOT_FOUND);
        }
        
        Formularioexportacion fe = servicioExportacion.findById(id);
        servicioExportacion.deleteFormularioExportacionById(fe);
        return new ResponseEntity<Formularioexportacion>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All FormularioArancelario --------------------------------------------------------
     
    @RequestMapping(value = "/FE/", method = RequestMethod.DELETE)
    public ResponseEntity<Formularioexportacion> deleteAllUsers() {
        System.out.println("Deleting formularios exportacion ");
        
        servicioExportacion.deleteAllFormularioexportacion();
        return new ResponseEntity<Formularioexportacion>(HttpStatus.NO_CONTENT);
    }
    
}
