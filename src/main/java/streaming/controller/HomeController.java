/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = "/home_page",method=RequestMethod.GET)
    public String homepage(Model m){
        
        //transmttre un attribut vers ma jsp, jutilise model
        
        m.addAttribute("titre","Bienvenue sur le site");
        return "home_page.jsp";
    }
    
}
