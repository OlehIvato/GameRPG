package spring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mobs")
public class MobsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @Column(name = "minDamage")
    private int minDamage;

    @Column(name = "maxDamage")
    private int maxDamage;

    @Column(name = "chanceToSuperDamage")
    private int chanceToSuperDamage;


}
