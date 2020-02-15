package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.HeroModel;
import spring.service.HeroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hero/")
public class HeroController {

  private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }


    @GetMapping("all")
    public List <HeroModel> findAll() {
        return heroService.findAll();
    }

    @GetMapping("id/{id}")
    public Optional <HeroModel> findOneById(@PathVariable("id") Long id) {
        return heroService.findOneById(id);
    }

    @GetMapping("save/{id}/{name}/{hp}/{damage}/{minSpell}/{maxSpell}/{restore}/{mana}")
    public HeroModel save(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("hp") int hp, @PathVariable("damage") int damage, @PathVariable("minSpell") int minSpell, @PathVariable("maxSpell") int maxSpell, @PathVariable("restore") int restore, @PathVariable("mana") int mana) {
        HeroModel heroModel = new HeroModel();
        heroModel.setId(id);
        heroModel.setName(name);
        heroModel.setHp(hp);
        heroModel.setDamage(damage);
        heroModel.setMinSpell(minSpell);
        heroModel.setMaxSpell(maxSpell);
        heroModel.setRestore(restore);
        heroModel.setMana(mana);
        return heroService.save(heroModel);
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        heroService.delete(id);
    }

    @GetMapping("name/{name}")
    public List <HeroModel> getName(@PathVariable("name") String name) {
        return heroService.getName(name);
    }
    @GetMapping("names")
    public   void  readAllBy() {
        List<HeroModel> heroModels = heroService.readAllBy("name");

    }

}

