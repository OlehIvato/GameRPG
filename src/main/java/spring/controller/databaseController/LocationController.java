package spring.controller.databaseController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.databaseModel.LocationModel;
import spring.service.LocationService;

@Controller
@RequestMapping("location/")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("all")
    public String findAll(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "database/location/location_list";
    }

    @GetMapping("create")
    public String createHeroForm() {
        return "database/location/location_update";
    }

    @PostMapping("create")
    public String create(LocationModel locationModel) {
        locationService.save(locationModel);
        return "redirect:/location/all";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("locations", locationService.findOneById(id));
        return "database/location/location_update";
    }

    @PostMapping("update")
    public String update(LocationModel locationModel) {
        locationService.save(locationModel);
        return "redirect:/location/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        locationService.delete(id);
        return "redirect:/location/all";
    }

}
