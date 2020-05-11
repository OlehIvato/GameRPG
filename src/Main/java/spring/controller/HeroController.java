package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.model.*;
import spring.repository.Hero_ArmorsRepository;
import spring.repository.Hero_ClassesRepository;
import spring.service.HeroService;

import java.util.List;

@Controller
@RequestMapping("hero/")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private Hero_ClassesRepository heroClassesRepository;

    @Autowired
    private Hero_ArmorsRepository heroArmorsRepository;

    @GetMapping("all")
    public String findAll(Model model) {
        List<HeroModel> heroModels = heroService.findAll();
        model.addAttribute("heroes", heroModels);
        return "database/hero/hero_list";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "database/hero/hero_update";
    }

    @PostMapping("create")
    public String create(HeroModel heroModel, @RequestParam("img") MultipartFile file) {
        heroService.saveWithImage(heroModel, file);
        return "redirect:/hero/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        HeroModel heroModel = heroService.findOneById(id);
        model.addAttribute("heroes", heroModel);
        model.addAttribute("hero_class", new Hero_Classes());
        model.addAttribute("armors", new Hero_Armors());
        return "database/hero/hero_update";
    }

    @PostMapping("update")
    public String update(HeroModel heroModel, Hero_Classes hero_classes, Hero_Armors hero_armors, @RequestParam("img") MultipartFile file) {
        heroService.saveWithImage(heroModel, file);
        hero_classes.setHero_id(heroModel.getId());
        heroClassesRepository.save(hero_classes);
        hero_armors.setHero_id(heroModel.getId());
        heroArmorsRepository.save(hero_armors);
        return "redirect:/hero/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        heroService.delete(id);
        return "redirect:/hero/all";
    }

}




