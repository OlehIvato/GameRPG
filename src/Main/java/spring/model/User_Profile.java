package spring.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "t_user_profile", schema = "minirpggame")
public class User_Profile {

    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "profile_id")
    private Long profile_id;

}