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

    @Column(name = "restore_hp_index")
    private int DEFAULT_RESTORE_HP_INDEX;

    @Column(name = "heal_cast_index")
    private int DEFAULT_HEAL_CAST;

    @Column(name = "super_damage")
    private double SUPER_DAMAGE;

    @Column(name = "level_count")
    private int LEVEL_COUNT;

    @Column(name = "without_equipment_dufficult")
    private int DEFAULT_GAME_WITHOUT_EQUIP_INDEX;


}
