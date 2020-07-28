package spring.controller.databaseController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.model.databaseModel.HeroModel;
import spring.model.databaseModel.Hero_Armors;
import spring.model.databaseModel.Hero_Classes;
import spring.repository.databaseRepository.Hero_ArmorsRepository;
import spring.repository.databaseRepository.Hero_ClassesRepository;
import spring.service.HeroService;

@Controller
@RequestMapping("hero/")
@AllArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final Hero_ClassesRepository heroClassesRepository;
    private final Hero_ArmorsRepository heroArmorsRepository;

    @GetMapping("all")
    public String findAll(Model model) {
        model.addAttribute("heroes", heroService.findAll());
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
        model.addAttribute("heroes", heroService.findOneById(id));
        model.addAttribute("hero_class", heroClassesRepository.getOne(id));
        model.addAttribute("hero_armors", heroArmorsRepository.getOne(id));
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



