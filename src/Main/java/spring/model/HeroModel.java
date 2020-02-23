package spring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hero")
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

    @Column(name = "minspelldamage")
    private int minSpell;

    @Column(name = "maxspelldamage")
    private int maxSpell;

    @Column(name = "restorehealth")
    private int restore;

    @Column(name = "mana")
    private int mana;

}


