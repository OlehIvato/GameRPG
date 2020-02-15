package spring.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location")
public class LocationModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "heroHp")
    private int heroHp;

    @Column(name = "heroDamage")
    private int heroDamage;

    @Column(name = "heroSpellDamage")
    private int heroSpellDamage;

    @Column(name = "heroRestoreHealth")
    private int heroRestoreHealth;

    @Column(name = "creatureHp")
    private int creatureHp;

    @Column(name = "creatureDamage")
    private int creatureDamage;

    @Column(name = "creatureChance")
    private int creatureChance;



}
