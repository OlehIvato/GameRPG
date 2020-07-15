package spring.model.gameModel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "game_creature", schema = "minirpggame")
public class Game_Creature_Model {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @Column(name = "min_damage")
    private int minDamage;

    @Column(name = "max_damage")
    private int maxDamage;

    @Column(name = "restore_hp")
    private int restoreHp;

    @Column(name = "chance_to_super_damage")
    private int chanceToSuperDamage;


}