package spring.model.gameModel;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "game_location", schema = "minirpggame")
@NoArgsConstructor
public class Game_Location_Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "hero_hp")
    private int heroHp;

    @Column(name = "hero_damage")
    private int heroDamage;

    @Column(name = "hero_energy")
    private int heroEnergy;

    @Column(name = "hero_spell")
    private int heroSpellDamage;

    @Column(name = "hero_mana")
    private int heroMana;

    @Column(name = "hero_restore")
    private int heroRestoreHealth;

    @Column(name = "creature_hp")
    private int creatureHp;

    @Column(name = "creature_chance")
    private int creatureDamage;

    @Column(name = "creature_damage")
    private int creatureChance;

    public Game_Location_Model(String username) {
        this.username = username;
    }


}
