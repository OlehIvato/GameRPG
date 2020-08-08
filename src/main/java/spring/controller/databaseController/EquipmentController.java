package spring.controller.databaseController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.databaseModel.EquipmentModel;
import spring.service.EquipmentService;

@Controller
@RequestMapping("equipment/")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;


    @GetMapping("all")
    public String findAll(Model model) {
        model.addAttribute("equipment", equipmentService.findAll());
        return "database/equipment/equipment_list";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "database/equipment/equipment_update";
    }

    @PostMapping("create")
    public String create(EquipmentModel equipmentModel) {
        equipmentService.save(equipmentModel);
        return "redirect:/equipment/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("equipment", equipmentService.findOneById(id));
        return "database/equipment/equipment_update";
    }

    @PostMapping("update")
    public String update(EquipmentModel equipmentModel) {
        equipmentService.save(equipmentModel);
        return "redirect:/equipment/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/equipment/all";
    }
}
