package spring.model.gameModel;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "game_hero", schema = "minirpggame")
public class Game_Hero_Model {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "hero_id")
    private Long heroID;

    @Column(name = "hp")
    private int hp;

    @Column(name = "damage")
    private int damage;

    @Column(name = "minspell")
    private int minSpell;

    @Column(name = "maxspell")
    private int maxSpell;

    @Column(name = "restorehp")
    private int restore;

    @Column(name = "mana")
    private int mana;

    @Column(name = "class_id")
    private Long heroClass;

    @Column(name = "armor_id")
    private Long armor;

}
