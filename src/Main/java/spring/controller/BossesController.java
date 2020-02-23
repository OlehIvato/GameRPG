package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.BossesModel;
import spring.service.BossesService;

import java.util.List;



@Controller
@RequestMapping("boss/")
public class BossesController {

    private final BossesService bossesService;

    public BossesController(BossesService bossesService) {
        this.bossesService = bossesService;
    }

    @GetMapping("all")
    public String findAll(Model model) {
        List<BossesModel> bossesModels = bossesService.findAll();
        model.addAttribute("bosses", bossesModels);
        return "Boss/BossList";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "Boss/BossUpdate";
    }

    @PostMapping("create")
    public String create(BossesModel bossesModels) {
        bossesService.save(bossesModels);
        return "redirect:/boss/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        BossesModel bossesModels = bossesService.findOneById(id);
        model.addAttribute("bosses", bossesModels);
        return "Boss/BossUpdate";
    }

    @PostMapping("update")
    public String update(BossesModel bossesModels) {
        bossesService.save(bossesModels);
        return "redirect:/boss/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bossesService.delete(id);
        return "redirect:/boss/all";
    }
}
