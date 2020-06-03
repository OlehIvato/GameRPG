package spring.controller.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.EquipmentModel;
import spring.service.EquipmentService;
import java.util.List;


@Controller
@RequestMapping("game/")
public class Equipment_SelectController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("equipment-select/{id}")
    public String findAll(Model model, @PathVariable(name = "id") Long id) {
        List<EquipmentModel> equipmentModels = equipmentService.findAll();
        model.addAttribute("equipment", equipmentModels);
        return "game/equipment-select";
    }
}