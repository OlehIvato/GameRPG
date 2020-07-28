package spring.model.databaseModel;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "hero", schema = "minirpggame")
public class HeroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @Column(name = "damage")
    private int damage;

    @Column(name = "energy")
    private int energy;

    @Column(name = "energy_res")
    private int energyRes;

    @Column(name = "minspelldamage")
    private int minSpell;

    @Column(name = "maxspelldamage")
    private int maxSpell;

    @Column(name = "restorehealth")
    private int restore;

    @Column(name = "mana")
    private int mana;

    @Column(name = "mana_res")
    private int manaRes;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Class> classes;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Armor> armors;



}




