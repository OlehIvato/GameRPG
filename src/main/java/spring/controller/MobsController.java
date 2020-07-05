package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.MobsModel;
import spring.service.MobsService;

@Controller
@RequestMapping("mob/")
public class MobsController {

    private final MobsService mobsService;

    public MobsController(MobsService mobsService) {
        this.mobsService = mobsService;
    }

    @GetMapping("all")
    public String findAll(Model model) {
        model.addAttribute("mobs", mobsService.findAll());
        return "database/mob/mob_list";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "database/mob/mob_update";
    }

    @PostMapping("create")
    public String create(MobsModel mobsModel) {
        mobsService.save(mobsModel);
        return "redirect:/mob/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mobs", mobsService.findOneById(id));
        return "database/mob/mob_update";
    }

    @PostMapping("update")
    public String update(MobsModel mobsModel) {
        mobsService.save(mobsModel);
        return "redirect:/mob/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        mobsService.delete(id);
        return "redirect:/mob/all";
    }
}
