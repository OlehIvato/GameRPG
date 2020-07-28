package spring.model.databaseModel;

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

    @Column(name = "mindamage")
    private int minDamage;

    @Column(name = "maxdamage")
    private int maxDamage;

    @Column(name = "chancetosuperdamage")
    private int chanceToSuperDamage;


}
