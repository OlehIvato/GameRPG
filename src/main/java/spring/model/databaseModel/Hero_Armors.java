package spring.model.databaseModel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hero_armors", schema = "minirpggame")
public class Hero_Armors {

    @Id
    @Column(name = "hero_model_id")
    private Long hero_id;

    @Column(name = "armors_id")
    private Long armor_id;


}