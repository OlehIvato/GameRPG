package spring.controller.databaseController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.databaseModel.BossesModel;
import spring.service.BossesService;

@Controller
@RequestMapping("boss/")
@AllArgsConstructor
public class BossesController {

    private final BossesService bossesService;

    @GetMapping("all")
    public String findAll(Model model) {
        model.addAttribute("bosses", bossesService.findAll());
        return "database/boss/boss_list";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "database/boss/boss_update";
    }

    @PostMapping("create")
    public String create(BossesModel bossesModels) {
        bossesService.save(bossesModels);
        return "redirect:/boss/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bosses", bossesService.findOneById(id));
        return "database/boss/boss_update";
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
