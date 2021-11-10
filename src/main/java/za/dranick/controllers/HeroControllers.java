package za.dranick.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.dranick.dao.HeroicDAO;

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
    
}
