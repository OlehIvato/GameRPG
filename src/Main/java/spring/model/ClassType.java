package spring.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "class")
public class ClassType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "class")
    private String className;

    @Transient
    @ManyToMany
    private Set<HeroModel> heroes;
}
