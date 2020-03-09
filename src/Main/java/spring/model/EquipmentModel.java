package spring.model;

import lombok.Data;

import javax.persistence.*;


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

    @Column(name = "spell_damage")
    private int spell_damage;

    @Column(name = "mana")
    private int mana;

    @Column(name = "type")
    private String type;

    @Column(name = "type_armor")
    private String type_armor;


}









