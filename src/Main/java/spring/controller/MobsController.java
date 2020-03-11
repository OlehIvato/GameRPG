package spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.MobsModel;
import spring.service.MobsService;

import java.util.List;


@Controller
@RequestMapping("mob/")
public class MobsController {

    private final MobsService mobsService;

    public MobsController(MobsService mobsService) {
        this.mobsService = mobsService;
    }


    @GetMapping("all")
    public String findAll(Model model) {
        List<MobsModel> mobsModel = mobsService.findAll();
        model.addAttribute("mobs", mobsModel);
        return "Database/Mob/mob_list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("create")
    public String createHeroForm() {
        return "Database/Mob/mob_update";
    }

    @PostMapping("create")
    public String create(MobsModel mobsModel) {
        mobsService.save(mobsModel);
        return "redirect:/mob/all";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        MobsModel mobsModel = mobsService.findOneById(id);
        model.addAttribute("mobs", mobsModel);
        return "Database/Mob/mob_update";
    }

    @PostMapping("update")
    public String update(MobsModel mobsModel) {
        mobsService.save(mobsModel);
        return "redirect:/mob/all";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        mobsService.delete(id);
        return "redirect:/mob/all";
    }
}
