package spring.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "t_profile", schema = "minirpggame")
public class Profile {

    @Id
    @Column(name = "id")
    private Long id;

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

    @Transient
    @ManyToMany
    private Set<User> user;

}