package spring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bosses")
public class BossesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @Column(name = "mindamage")
    private int minDamage;

    @Column(name = "maxdamage")
    private int maxDamage;

    @Column(name = "restorehealth")
    private int restoreHealth;

    @Column(name = "chancetosuperdamage")
    private int chanceToSuperDamage;

}
