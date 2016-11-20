/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.controlador;

import aduana.modelo.Formularioexportacion;
import aduana.service.FormExportacionService;
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

import org.springframework.ui.ModelMap;

@RestController
public class RestFormExportacion {
    @Autowired
    FormExportacionService FormularioExportacion;  //Service which will do all data retrieval/manipulation work
    
    
         
    //-------------------Recive todos los formularios--------------------------------------------------------
      
    @RequestMapping(value = "/FE/", method = RequestMethod.GET)
    public ResponseEntity<List<Formularioexportacion>> findAllFormExportacion() {
        List<Formularioexportacion> formExpor = FormularioExportacion.findAllFormExportacion();
        if(formExpor.isEmpty()){
            return new ResponseEntity<List<Formularioexportacion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Formularioexportacion>>(formExpor, HttpStatus.OK);
    }
}
