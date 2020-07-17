package spring.controller.gameController;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.model.EquipmentModel;
import spring.model.User;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.repository.EquipmentRepository;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.service.imp.EquipmentServiceImp;


@Controller
@AllArgsConstructor
@RequestMapping("game/equipment/")
public class SelectEquipmentController {

    private final EquipmentServiceImp equipmentServiceImp;
    private final Game_HeroRepository gameHeroRepository;
    private final EquipmentRepository equipmentRepository;
    private final Game_FightRepository gameFightRepository;

    static int typeForEquipment = 0; // from 1 to 4 need for main equipment like (head,shoulder,chest,legs)
    static int typeForWeapon = 0; // from 5 to 8


    @GetMapping("get/{armorId}")
    public String get(@AuthenticationPrincipal User currentUser, @PathVariable("armorId") int armorId) {
        Game_Fight_Model fight = gameFightRepository.findByUsername(currentUser.getUsername());
        fight.setIsGameWithEquipments(1);
        gameFightRepository.save(fight);
        if (fight.getIsGameStarted() == 1) {
            return "rpg/forbidden_move";
        }

        typeForEquipment++;
        if (typeForEquipment >= 4) {
            return "redirect:/game/equipment/weapon"
                    + "/" + armorId;
        } else
            return "redirect:/game/equipment/select"
                    + "/" + typeForEquipment
                    + "/" + armorId;
    }


    @GetMapping("weapon/{armorId}")
    public String getWeapon(@AuthenticationPrincipal User currentUser,
                            @PathVariable("armorId") int armorId,
                            Model model) {
        class HeroClass {
            private static final byte MAGE = 1;
            private static final byte WARRIOR = 2;
            private static final byte DRUID = 3;
            private static final byte ROGUE = 4;
            private static final byte MONK = 5;
            private static final byte SHAMAN = 6;
            private static final byte PRIEST = 7;
            private static final byte HUNTER = 8;
            private static final byte PALADIN = 9;
        }

        class Type {
            private static final byte WAND = 5;
            private static final byte SWORD = 6;
            private static final byte SHIELD = 7;
            private static final byte AMULET = 8;

        }

        Game_Hero_Model hero = gameHeroRepository.findByUsername(currentUser.getUsername());
        model.addAttribute("hero", hero);
        long classId = hero.getHeroClass();
        byte weaponArmorId = 4;
        typeForWeapon++;
        if (typeForWeapon == 1) {
            if (classId == HeroClass.MAGE
                    || classId == HeroClass.SHAMAN
                    || classId == HeroClass.PALADIN
                    || classId == HeroClass.PRIEST
                    || classId == HeroClass.DRUID) {
                model.addAttribute("type", Type.WAND);
                model.addAttribute("equipment", equipmentServiceImp.findByArmorsAndTypes(weaponArmorId, Type.WAND));
                return "rpg/select_equipment";
            }
        }
        if (typeForWeapon == 2) {
            if (classId == HeroClass.WARRIOR
                    || classId == HeroClass.MONK
                    || classId == HeroClass.HUNTER
                    || classId == HeroClass.ROGUE) {
                model.addAttribute("type", Type.SWORD);
                model.addAttribute("equipment", equipmentServiceImp.findByArmorsAndTypes(weaponArmorId, Type.SWORD));
                return "rpg/select_equipment";
            }
        }
        if (typeForWeapon == 3) {
            if (classId == HeroClass.DRUID
                    || classId == HeroClass.PRIEST
                    || classId == HeroClass.MAGE) {
                model.addAttribute("type", Type.AMULET);
                model.addAttribute("equipment", equipmentServiceImp.findByArmorsAndTypes(weaponArmorId, Type.AMULET));
                return "rpg/select_equipment";
            }
        }
        if (typeForWeapon == 4) {
            if (hero.getHp() < 150) {
                model.addAttribute("type", Type.SHIELD);
                model.addAttribute("equipment", equipmentServiceImp.findByArmorsAndTypes(weaponArmorId, Type.SHIELD));
                return "rpg/select_equipment";
            }
        }
        if (typeForWeapon > 4) {
            return "redirect:/game/menu/get-location";
        }
        return "redirect:/game/equipment/weapon"
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
        model.addAttribute("type", typeForEquipment);
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

