package spring.controller.databaseController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.model.databaseModel.HeroModel;
import spring.service.HeroService;

@Controller
@RequestMapping("hero/")
@AllArgsConstructor
public class HeroController {

    private final HeroService heroService;

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
        return "database/hero/hero_update";
    }

    @PostMapping("update")
    public String update(HeroModel heroModel,  @RequestParam("img") MultipartFile file) {
        heroService.saveWithImage(heroModel, file);
        return "redirect:/hero/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        heroService.delete(id);
        return "redirect:/hero/all";
    }
}




