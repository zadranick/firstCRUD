package za.dranick.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.dranick.dao.HeroicDAO;
import za.dranick.models.Hero;

import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroControllers {

    private final HeroicDAO heroicDAO;

    public HeroControllers(HeroicDAO heroicDAO) {
        this.heroicDAO = heroicDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("heroes", heroicDAO.index());
        return "heroes/index";
    }

     @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("hero", heroicDAO.show(id));
        return "heroes/show";
    }

    @GetMapping("/new")
    public String newHero(@ModelAttribute("hero") Hero hero){
        return "heroes/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("hero") @Valid Hero hero, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "heroes/new";

        heroicDAO.save(hero);
        return "redirect:/heroes";

    }



    
}
