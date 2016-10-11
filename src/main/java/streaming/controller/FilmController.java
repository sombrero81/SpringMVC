/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.service.FilmCrudService;
import streaming.service.GenreCrudService;

/**
 *
 * @author tom
 */
@Controller
//@RequestMapping("/film")
public class FilmController {
    
    @Autowired
    private FilmCrudService fservice;
    
    
    //concatenation
//    @RequestMapping(value="find/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public Film findById( @PathVariable("id") long id){
//        
//        Film f = new Film(1L, "Karate Kid", "blabla", 1989L, null);
//        
//        return f;
//    }
    
    //affichage des films
    @RequestMapping(value={"/liste_films","/"},method=RequestMethod.GET)
    public String lister(Model model){
        
        //model pour le transfert des attributs
        model.addAttribute("mesfilms", fservice.findAll());
        return "film_lister.jsp";        
                
    }
    
    
    @Autowired
    private GenreCrudService genreservice;
    
    //ajout d1 nouveau film
     @RequestMapping(value="/ajouter_film",method = RequestMethod.GET)
    public String ajouter(Model model){
        
        Film f=new Film();
        f.setSynopsis("synopsis ici");
        model.addAttribute("nouveauFilm", f);
        model.addAttribute("genres", genreservice.findAll());
        return "ajouter_film.jsp";
    }
    
    
    @RequestMapping(value = "/ajouter_film",method = RequestMethod.POST)
    public String ajoutPOST(@ModelAttribute("nouveauFilm") Film film){
        
        //persiste genre
        fservice.save(film);
        
        //redirect  liste des genres
        return "redirect:/liste_films";
        
    }
    
    //supression de film
     @RequestMapping(value="/supprimer_film/{val}",method =RequestMethod.GET)
    public String supprimer(@PathVariable("val") long idFilmASupprimer){
        
     fservice.delete(idFilmASupprimer);
     return "redirect:/liste_films";
    }
    
    //modifier film
    @RequestMapping(value="/modifier_film/{idFilm}",method =RequestMethod.GET)
    public String modifierGET(@PathVariable("idFilm") long id,Model model){
        
        //recup genre
        Film film = fservice.findOne(id);
        
        //prep l'attribut a destination de jsp
        model.addAttribute("filmAct", film);
        model.addAttribute("genres", genreservice.findAll());
                
        //envoi vers la jsp
        return "modifier_film.jsp";
        
    }
    
    @RequestMapping(value="/modifier_film",method=RequestMethod.POST)
    public String modifierPOST(@ModelAttribute("filmAct")Film film){
        
        fservice.save(film);
        return "redirect:/liste_films";
        
    }
    
    
    
}
