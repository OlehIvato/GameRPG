package spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "armor")
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "armor")
    private String armorName;

    @Transient
    @ManyToMany
    private Set<HeroModel> heroes;

    @Transient
    @ManyToMany
    private Set<EquipmentModel> equipmentModels;
}