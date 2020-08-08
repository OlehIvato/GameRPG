package spring.controller.gameController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.User;
import spring.model.databaseModel.Class;
import spring.model.databaseModel.EquipmentModel;
import spring.model.gameModel.Game_Equipment_Setting_Model;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.repository.ClassRepository;
import spring.repository.databaseRepository.EquipmentRepository;
import spring.repository.gameRepository.Game_Equipment_SettingRepository;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.service.imp.EquipmentServiceImp;

@Controller
@RequestMapping("game/equipment/")
public class SelectEquipmentController {

    private final EquipmentServiceImp equipmentServiceImp;
    private final Game_HeroRepository gameHeroRepository;
    private final EquipmentRepository equipmentRepository;
    private final Game_FightRepository gameFightRepository;
    private final Game_Equipment_SettingRepository game_equipment_settingRepository;
    private final ClassRepository classRepository;


    public SelectEquipmentController(EquipmentServiceImp equipmentServiceImp,
                                     Game_HeroRepository gameHeroRepository,
                                     EquipmentRepository equipmentRepository,
                                     Game_FightRepository gameFightRepository,
                                     Game_Equipment_SettingRepository game_equipment_settingRepository,
                                     ClassRepository classRepository) {
        this.equipmentServiceImp = equipmentServiceImp;
        this.gameHeroRepository = gameHeroRepository;
        this.equipmentRepository = equipmentRepository;
        this.gameFightRepository = gameFightRepository;
        this.game_equipment_settingRepository = game_equipment_settingRepository;
        this.classRepository = classRepository;
    }

    static int typeCount = 0;

    @GetMapping("get/{armorId}")
    public String generateEquipment(@AuthenticationPrincipal User currentUser, @PathVariable("armorId") int armorId) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        fight.setIsGameWithEquipments(1);
        gameFightRepository.save(fight);
        if (fight.getIsGameStarted() == 1) {
            return "rpg/forbidden_move";
        }
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        Game_Equipment_Setting_Model equip_setting = game_equipment_settingRepository.getOne(hero.getHeroClass());
        Class heroClass = classRepository.getOne(equip_setting.getId());
        byte weaponId = 4;
        typeCount++;
        if (heroClass.getId().equals(equip_setting.getId())) {
            if (equip_setting.getHead() == 1 && typeCount == 1) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + armorId;
            }
            if (equip_setting.getShoulder() == 1 && typeCount == 2) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + armorId;
            }
            if (equip_setting.getChest() == 1 && typeCount == 3) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + armorId;
            }
            if (equip_setting.getLegs() == 1 && typeCount == 4) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + armorId;
            }
            if (equip_setting.getWand() == 1 && typeCount == 5) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + weaponId;
            }
            if (equip_setting.getSword() == 1 && typeCount == 6) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + weaponId;
            }
            if (equip_setting.getShield() == 1 && typeCount == 7) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + weaponId;
            }
            if (equip_setting.getAmulet() == 1 && typeCount == 8) {
                return "redirect:/game/equipment/select"
                        + "/" + typeCount
                        + "/" + weaponId;
            }
            if (typeCount > 8) {
                typeCount = 0;
                return "redirect:/game/menu/get-location";

            }
        }
        return "redirect:/game/equipment/get"
                + "/" + armorId;
    }

    @GetMapping("select/{typeId}/{armorId}")
    public String getAllEquipments(@AuthenticationPrincipal User currentUser,
                                   @PathVariable("typeId") int typeId,
                                   @PathVariable("armorId") int armorId,
                                   Model model) {
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        model.addAttribute("hero", hero);
        model.addAttribute("user", currentUser.getUsername());
        model.addAttribute("type", typeId);
        model.addAttribute("equipment", equipmentServiceImp.findByArmorsAndTypes(armorId, typeId));
        return "rpg/select_equipment";
    }

    @GetMapping("save/{armorId}/{equipmentId}")
    public String save(@AuthenticationPrincipal User currentUser,
                       @PathVariable("armorId") int armorId,
                       @PathVariable("equipmentId") long equipmentId) {
        EquipmentModel equipment = equipmentRepository.getOne(equipmentId);
        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        hero.setHp(hero.getHp() + equipment.getHp());
        hero.setDamage(hero.getDamage() + equipment.getDamage());
        hero.setEnergy(hero.getEnergy() + equipment.getEnergy());
        hero.setEnergyRes(hero.getEnergyRes() + equipment.getEnergyRes());
        hero.setMinSpell(hero.getMinSpell() + equipment.getSpell_damage());
        hero.setMaxSpell(hero.getMaxSpell() + equipment.getSpell_damage());
        hero.setMana(hero.getMana() + equipment.getMana());
        hero.setManaRes(hero.getManaRes() + equipment.getManaRes());
        gameHeroRepository.save(hero);
        return "redirect:/game/equipment/get"
                + "/" + armorId;
    }
}


