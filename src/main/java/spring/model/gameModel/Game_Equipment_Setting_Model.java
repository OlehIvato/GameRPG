package spring.model.gameModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.model.Profile;
import spring.model.databaseModel.Class;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "game_equipment_setting", schema = "minirpggame")
@NoArgsConstructor
@AllArgsConstructor
public class Game_Equipment_Setting_Model {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    @Column(name = "class_id")
    private int class_id;

    @OneToMany
    @JoinColumn(name = "id", updatable = false)
    private List<Class> className = new ArrayList<>();

    @Column(name = "head")
    private int head;

    @Column(name = "shoulder")
    private int shoulder;

    @Column(name = "chest")
    private int chest;

    @Column(name = "legs")
    private int legs;

    @Column(name = "wand")
    private int wand;

    @Column(name = "sword")
    private int sword;

    @Column(name = "shield")
    private int shield;

    @Column(name = "amulet")
    private int amulet;
}
