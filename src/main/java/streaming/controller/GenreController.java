/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Genre;
import streaming.service.GenreCrudService;

/**
 *
 * @author admin
 */

@Controller
public class GenreController {
    
    
    @Autowired
    private GenreCrudService service;
    
    
    //le controlleur renvoit touj du string
    //on cree une fonction lister
    @RequestMapping(value="/liste_genres",method = RequestMethod.GET)
    public String lister(Model model){
        
       model.addAttribute("mesGenres", service.findAll());  
                
        return "genre_lister.jsp";
    }
    
}
