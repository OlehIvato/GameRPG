package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.MobsModel;
import spring.service.MobsService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("mobs/")
public class MobsController {

    private final MobsService mobsService;

    public MobsController(MobsService mobsService) {
        this.mobsService = mobsService;
    }


    @GetMapping("all")
    public List<MobsModel> findAll() {
        return mobsService.findAll();
    }


    @GetMapping("id/{id}")
    public Optional<MobsModel> findOneById(@PathVariable("id") Long id) {
        return mobsService.findOneById(id);
    }

    @GetMapping("save/{id}/{name}/{hp}/{minDamage}/{maxDamage}/{chanceToSuperDamage}")
    public MobsModel save(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("hp") int hp, @PathVariable("minDamage") int minDamage, @PathVariable("maxDamage") int maxDamage, @PathVariable("chanceToSuperDamage") int chanceToSuperDamage) {
        MobsModel mobsModel = new MobsModel();
        mobsModel.setId(id);
        mobsModel.setName(name);
        mobsModel.setHp(hp);
        mobsModel.setMinDamage(minDamage);
        mobsModel.setMaxDamage(maxDamage);
        mobsModel.setChanceToSuperDamage(chanceToSuperDamage);
        return mobsService.save(mobsModel);
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        mobsService.delete(id);
    }

    @GetMapping("name/{name}")
    public List<MobsModel> getName(@PathVariable("name") String name) {
        return mobsService.getName(name);
    }



}
