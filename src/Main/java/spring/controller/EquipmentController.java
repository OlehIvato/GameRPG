package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.EquipmentModel;
import spring.model.Equipment_Armors;
import spring.model.Equipment_Types;
import spring.repository.Equipment_ArmorsRepository;
import spring.repository.Equipment_TypesRepository;
import spring.service.EquipmentService;

import java.util.List;

@Controller
@RequestMapping("equipment/")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private Equipment_TypesRepository equipmentTypesRepository;
    @Autowired
    private Equipment_ArmorsRepository equipment_armorsRepository;


    @GetMapping("all")
    public String findAll(Model model) {
        List<EquipmentModel> equipmentModels = equipmentService.findAll();
        model.addAttribute("equipment", equipmentModels);
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
        EquipmentModel equipmentModel = equipmentService.findOneById(id);
        model.addAttribute("equipment", equipmentModel);
        model.addAttribute("equipment_type", equipmentTypesRepository.getOne(id));
        model.addAttribute("equipment_armor", equipment_armorsRepository.getOne(id));
        return "database/equipment/equipment_update";
    }

    @PostMapping("update")
    public String update(EquipmentModel equipmentModel, Equipment_Types equipment_types, Equipment_Armors equipment_armors) {
        equipmentService.save(equipmentModel);
        equipment_types.setEquipment_id(equipmentModel.getId());
        equipmentTypesRepository.save(equipment_types);
        equipment_armors.setEquipment_model_id(equipmentModel.getId());
        equipment_armorsRepository.save(equipment_armors);
        return "redirect:/equipment/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        equipmentService.delete(id);
        return "redirect:/equipment/all";
    }


}
