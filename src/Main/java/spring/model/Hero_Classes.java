package spring.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "hero_classes", schema = "minirpggame")
public class Hero_Classes {

    @Id
    @Column(name = "hero_model_id")
    private Long hero_id;

    @Column(name = "classes_id")
    private Long class_id;


}
