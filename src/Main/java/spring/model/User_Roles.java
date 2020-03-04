package spring.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_user_roles")
public class User_Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "roles_id")
    private Long roles_id;

}
