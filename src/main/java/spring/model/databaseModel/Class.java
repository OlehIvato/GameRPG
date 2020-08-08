package spring.model.databaseModel;

import lombok.Data;
import spring.model.gameModel.Game_Equipment_Setting_Model;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class")
    private String className;

    @Transient
    @OneToOne
    private HeroModel heroes;

    @Transient
    @OneToMany
    private Set<Game_Equipment_Setting_Model> game_equipment_setting_models;

}
