package spring.model.databaseModel;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Transient
    @ManyToMany
    private Set<EquipmentModel> equipmentModels;

}