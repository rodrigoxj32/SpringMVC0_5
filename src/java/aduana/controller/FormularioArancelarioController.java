/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
<<<<<<< HEAD
public class FormularioArancelarioController {
    
    @RequestMapping(value="/formularioArancelario",method = RequestMethod.GET)
    public String vistaFormularioArancelario(ModelMap modelMap) {
=======
@RequestMapping("/formularioArancelario")
public class FormularioArancelarioController {
    
        @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(ModelMap modelMap) {
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
        System.out.println("invoco la jsp");
        modelMap.put("printme", "Hello Spring !!");
        return "formularioArancelario";
    }
<<<<<<< HEAD
    
    @RequestMapping(value="/formArancelario",method = RequestMethod.GET)
    public String vistaFormularioArancelario2(ModelMap modelMap) {
        System.out.println("invoco la jsp");
        modelMap.put("printme", "Hello Spring !!");
        return "formArancelario";
    }
=======
>>>>>>> ded8ed45bf60eccdd9124f32bde57f757b9c0fe3
}
