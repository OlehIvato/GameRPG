package spring.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.EquipmentModel;
import spring.service.EquipmentService;

import java.util.List;

@Controller
@RequestMapping("equipment/")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("all")
    public String findAll(Model model) {
        List<EquipmentModel> equipmentModels = equipmentService.findAll();
        model.addAttribute("equipment", equipmentModels);
        return "Database/Equipment/equipment_list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("create")
    public String createHeroForm() {
        return "Database/Equipment/equipment_update";
    }

    @PostMapping("create")
    public String create(EquipmentModel equipmentModel) {
        equipmentService.save(equipmentModel);
        return "redirect:/equipment/all";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        EquipmentModel equipmentModel = equipmentService.findOneById(id);
        model.addAttribute("equipment", equipmentModel);
        return "Database/Equipment/equipment_update";
    }

    @PostMapping("update")
    public String update(EquipmentModel equipmentModel) {
        equipmentService.save(equipmentModel);
        return "redirect:/equipment/all";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/equipment/all";
    }


}
