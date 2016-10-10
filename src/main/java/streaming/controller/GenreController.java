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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    @RequestMapping(value="/ajouter_genre",method = RequestMethod.GET)
    public String ajouter(Model model){
        
        model.addAttribute("nouveauGenre", new Genre());
        return "ajouter_genre.jsp";
    }
    
    
    @RequestMapping(value="/modifier_genre",method=RequestMethod.POST)
    public String modifierPOST(@ModelAttribute("genreAct")Genre genre){
        
        service.save(genre);
        return "redirect:/liste_genres";
        
    }
    
    
    //@RequestMapping(value="/supprimer_genre/{val1}/{val2}",method =RequestMethod.GET)
    //public String supprimer(@PathVariable("val1") long idGenreASupprimer,@pathvariable("val2")){
        
    
    @RequestMapping(value="/supprimer_genre/{val}",method =RequestMethod.GET)
    public String supprimer(@PathVariable("val") long idGenreASupprimer){
        
     service.delete(idGenreASupprimer);
     return "redirect:/liste_genres";
    }
    
    
    
    //le controlleur renvoit touj du string
    //on cree une fonction lister
    @RequestMapping(value={"/liste_genres","/"},method = RequestMethod.GET)
    public String lister(Model model){
        
       model.addAttribute("mesGenres", service.findAll());  
                
        return "genre_lister.jsp";
    }
    
    @RequestMapping(value="/modifier_genre/{idGenre}",method =RequestMethod.GET)
    public String modifierGET(@PathVariable("idGenre") long id,Model model){
        
        //recup genre
        Genre genre = service.findOne(id);
        
        //prep l'attribut a destination de jsp
        model.addAttribute("genreAct", genre);
                
        //envoi vers la jsp
        return "modifier_genre.jsp";
        
    }
    
}
