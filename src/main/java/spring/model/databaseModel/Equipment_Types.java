package spring.model.databaseModel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "equipment_types", schema = "minirpggame")
public class Equipment_Types {

    @Id
    @Column(name = "equipment_model_id")
    private Long equipment_id;

    @Column(name = "types_id")
    private Long types_id;
}