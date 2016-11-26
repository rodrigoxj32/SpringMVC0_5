/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.configuration;

import aduana.modelo.Formularioarancelario;
import aduana.service.FormArancelarioService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.ui.ModelMap;

@RestController
public class RestFormArancelario {
    @Autowired
    FormArancelarioService formularioArancelario;  //Service which will do all data retrieval/manipulation work
    
    
         
    //-------------------Recive todos los formularios--------------------------------------------------------
      
    @RequestMapping(value = "/FA/", method = RequestMethod.GET)
    public ResponseEntity<List<Formularioarancelario>> findAllFormArancelario() {
        List<Formularioarancelario> formArancel = formularioArancelario.findAllFormularioArancelario();
        if(formArancel.isEmpty()){
            return new ResponseEntity<List<Formularioarancelario>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Formularioarancelario>>(formArancel, HttpStatus.OK);
    }
    
    
    
        //-------------------Create a formulario--------------------------------------------------------
      
    @RequestMapping(value = "/FA/", method = RequestMethod.POST)
    public ResponseEntity<Void> createFormularioArancelario(@RequestBody Formularioarancelario fa,    UriComponentsBuilder ucBuilder) {
        
        /*
        System.out.println("Creating User " + user.getUsername());
  
        if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        userService.saveUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);*/
        System.out.println("entro a este metodo");
        
        formularioArancelario.saveFormularioArancelario(fa);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
}
