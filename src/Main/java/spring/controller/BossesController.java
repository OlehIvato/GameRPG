package spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.BossesModel;
import spring.service.BossesService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("bosses/")
public class BossesController {

    private final BossesService bossesService;

    public BossesController(BossesService bossesService) {
        this.bossesService = bossesService;
    }

    @GetMapping("all")
    public List<BossesModel> findAll() {
        return bossesService.findAll();
    }


    @GetMapping("id/{id}")
    public Optional<BossesModel> findOneById(@PathVariable("id") Long id) {
        return bossesService.findOneById(id);
    }

    @GetMapping("save/{id}/{name}/{hp}/{minDamage}/{maxDamage}/{restoreHealth}/{chanceToSuperDamage}")
    public BossesModel save(@PathVariable("id") Long id, @PathVariable("name") String name, @PathVariable("hp") int hp, @PathVariable("minDamage") int minDamage, @PathVariable("maxDamage") int maxDamage, @PathVariable("restoreHealth") int restoreHealth, @PathVariable("chanceToSuperDamage") int chanceToSuperDamage) {
        BossesModel bossesModel = new BossesModel();
        bossesModel.setId(id);
        bossesModel.setName(name);
        bossesModel.setHp(hp);
        bossesModel.setMinDamage(minDamage);
        bossesModel.setMaxDamage(maxDamage);
        bossesModel.setRestoreHealth(restoreHealth);
        bossesModel.setChanceToSuperDamage(chanceToSuperDamage);
        return bossesService.save(bossesModel);
    }

    @GetMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        bossesService.delete(id);
    }

    @GetMapping("name/{name}")
    public List<BossesModel> getName(@PathVariable("name") String name) {
        return bossesService.getName(name);
    }


}
