package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.HeroModel;
import spring.service.HeroService;

import java.util.List;

@Controller
@RequestMapping("hero/")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("all")
    public String findAll(Model model) {
        List<HeroModel> heroModels = heroService.findAll();
        model.addAttribute("heroes", heroModels);
        return "Hero/HeroList";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "Hero/HeroUpdate";
    }

    @PostMapping("create")
    public String create(HeroModel heroModel) {
        heroService.save(heroModel);
        return "redirect:/hero/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        HeroModel heroModel = heroService.findOneById(id);
        model.addAttribute("heroes", heroModel);
        return "Hero/HeroUpdate";
    }

    @PostMapping("update")
    public String update(HeroModel heroModel) {
        heroService.save(heroModel);
        return "redirect:/hero/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        heroService.delete(id);
        return "redirect:/hero/all";
    }
}

