package spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "t_profile", schema = "minirpggame")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private Integer zip;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar")
    private String avatar;

    @Transient
    @OneToOne
    private User user;


    public Profile(String username) {
        this.username = username;
    }

    public Profile() {
    }
}


