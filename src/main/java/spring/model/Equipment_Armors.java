package spring.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "equipment_armors", schema = "minirpggame")
public class Equipment_Armors {

    @Id
    @Column(name = "equipment_model_id")
    private Long equipment_model_id;

    @Column(name = "armors_id")
    private Long armors_id;


}