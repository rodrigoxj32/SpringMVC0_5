/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class indexController{
    
      @RequestMapping(method = RequestMethod.GET)
        public String helloWorld(Model modelMap, @RequestParam("usurio") String user  ) {
        
         modelMap.addAttribute("parametro", 5);
        return "index";
    }
        
    
    
}
