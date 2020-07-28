package spring.model.databaseModel;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "equipment")
public class EquipmentModel {

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

    @Column(name = "spell_damage")
    private int spell_damage;

    @Column(name = "mana")
    private int mana;

    @Column(name = "mana_res")
    private int manaRes;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Type> types;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Armor> armors;

}









