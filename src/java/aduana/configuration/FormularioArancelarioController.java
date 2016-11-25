/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.configuration;

/**
 *
 * @author jonathan
 */
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import sun.rmi.runtime.Log;
@Controller
public class FormularioArancelarioController { 


    @RequestMapping(value="/formularioArancelario",method = RequestMethod.GET)
    public ModelAndView helloWorld(Model saludo) {
        System.out.println("on method");
        //return "formularioArancelario";
        //("vista","nombremodelo",modeloobejto)
        return new ModelAndView("formularioArancelario", "mensaje", saludo);
       
    }
}
