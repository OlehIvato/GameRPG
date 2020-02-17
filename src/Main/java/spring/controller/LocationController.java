package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.LocationModel;
import spring.service.LocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("location/")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping("all")
    public List<LocationModel> findAll() {
        return locationService.findAll();
    }


    @GetMapping("id/{id}")
    public Optional<LocationModel> findOneById(@PathVariable("id") Long id) {
        return locationService.findOneById(id);
    }

    @GetMapping("save/{id}/{name}/{heroHp}/{heroDamage}/{heroSpellDamage}/{heroRestoreHealth}/{creatureHp}/{creatureDamage}/{creatureChance}")
    public LocationModel save(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("heroHp") int heroHp, @PathVariable("heroDamage") int heroDamage, @PathVariable("heroSpellDamage") int heroSpellDamage, @PathVariable("heroRestoreHealth") int heroRestoreHealth, @PathVariable("creatureHp") int creatureHp, @PathVariable("creatureDamage") int creatureDamage, @PathVariable("creatureChance") int creatureChance) {
        LocationModel locationModel = new LocationModel();
        locationModel.setId(id);
        locationModel.setName(name);
        locationModel.setHeroHp(heroHp);
        locationModel.setHeroDamage(heroDamage);
        locationModel.setHeroSpellDamage(heroSpellDamage);
        locationModel.setHeroRestoreHealth(heroRestoreHealth);
        locationModel.setCreatureHp(creatureHp);
        locationModel.setCreatureDamage(creatureDamage);
        locationModel.setCreatureChance(creatureChance);
        return locationService.save(locationModel);
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        locationService.delete(id);
    }

    @GetMapping("name/{name}")
    public List<LocationModel> getName(@PathVariable("name") String name) {
        return locationService.getName(name);
    }


}
