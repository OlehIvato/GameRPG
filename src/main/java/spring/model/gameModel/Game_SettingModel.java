package spring.model.gameModel;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "game_setting", schema = "minirpggame")
public class Game_SettingModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "level_difficult_percent")
    private int LEVEL_DIFFICULT_PERCENT;

    @Column(name = "restore_hp_index")
    private int RESTORE_HP_INDEX;

    @Column(name = "energy_hit_index")
    private int ENERGY_HIT_INDEX;

    @Column(name = "energy_multiply_index")
    private int ENERGY_MULTIPLY_INDEX;

    @Column(name = "heal_cast_index")
    private int HEAL_CAST_INDEX;

    @Column(name = "super_damage_multiply_index")
    private double SUPER_DAMAGE_MULTIPLY_INDEX;

    @Column(name = "level_count_index")
    private int LEVEL_COUNT_INDEX;

    @Column(name = "without_equipment_difficult_index")
    private int GAME_WITHOUT_EQUIP_DIFFICULTY;


}
