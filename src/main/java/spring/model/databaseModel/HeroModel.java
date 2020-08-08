package spring.model.databaseModel;

import lombok.Data;
import spring.model.Profile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    @Column(name = "armor_id")
    private Long armor_id;

    @Column(name = "class_id")
    private Long class_id;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "armor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Armor armor;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Class classes;


}




