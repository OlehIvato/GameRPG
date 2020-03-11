package spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.LocationModel;
import spring.service.LocationService;

import java.util.List;

@Controller
@RequestMapping("location/")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping("all")
    public String findAll(Model model) {
        List<LocationModel> locationModel = locationService.findAll();
        model.addAttribute("locations", locationModel);
        return "Database/Location/location_list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("create")
    public String createHeroForm() {
        return "Database/Location/location_update";
    }

    @PostMapping("create")
    public String create(LocationModel locationModel) {
        locationService.save(locationModel);
        return "redirect:/location/all";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        LocationModel locationModel = locationService.findOneById(id);
        model.addAttribute("locations", locationModel);
        return "Database/Location/location_update";
    }

    @PostMapping("update")
    public String update(LocationModel locationModel) {
        locationService.save(locationModel);
        return "redirect:/location/all";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        locationService.delete(id);
        return "redirect:/location/all";
    }

}
