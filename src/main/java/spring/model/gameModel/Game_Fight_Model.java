package spring.model.gameModel;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "game_fight", schema = "minirpggame")
@NoArgsConstructor
public class Game_Fight_Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Game_Fight_Model(String username) {
        this.username = username;
    }
}








