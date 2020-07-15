package spring.model.gameModel;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "game_fight", schema = "minirpggame")
public class Game_Fight_Model {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "is_game_with_equipments")
    private int isGameWithEquipments;

    @Column(name = "is_boss_game")
    private int isBoss;

    @Column(name = "is_game_started")
    private int isGameStarted;

    @Column(name = "game_count")
    private int gameCount;

    @Column(name = "level_count")
    private int levelCount;

    @Column(name = "level_difficult")
    private int levelDifficult;


}








