package spring.dto;

import lombok.Data;
import spring.model.Profile;
import spring.model.User;
import spring.model.User_Profile;
import spring.model.User_Roles;
import java.util.Date;

@Data
public class User_ProfileDto {

    private Long id;
    private String username;
    private String email;
    private String name;
    private String password;
    private String password_current;
    private String password_new;
    private String password_confirm;
    private String surname;
    private Date birthday;
    private String gender;
    private String phone;
    private String country;
    private String city;
    private Integer zip;
    private String bio;
    private String avatar;

    private Long user_id;
    private Long profile_id;
    private Long roles_id;


    public User_ProfileDto(User user, Profile profile) {
        this.id = user.getId();
        this.id = profile.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = profile.getName();
        this.surname = profile.getSurname();
        this.birthday = profile.getBirthday();
        this.gender = profile.getGender();
        this.phone = profile.getPhone();
        this.country = profile.getCountry();
        this.city = profile.getCity();
        this.zip = profile.getZip();
        this.bio = profile.getBio();
        this.avatar = profile.getAvatar();
    }


    public User_ProfileDto(User user, Profile profile, User_Roles userRoles, User_Profile userProfile) {
        this.id = user.getId();
        this.id = profile.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = profile.getName();
        this.surname = profile.getSurname();
        this.birthday = profile.getBirthday();
        this.gender = profile.getGender();
        this.phone = profile.getPhone();
        this.country = profile.getCountry();
        this.city = profile.getCity();
        this.zip = profile.getZip();
        this.bio = profile.getBio();
        this.avatar = profile.getAvatar();

        this.user_id = userProfile.getUser_id();
        this.user_id = userRoles.getUser_id();
        this.profile_id = userProfile.getProfile_id();
        this.roles_id = userRoles.getRoles_id();
    }


    public User_ProfileDto(User user, User_Roles userRoles, User_Profile userProfile) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();

        this.user_id = userProfile.getUser_id();
        this.user_id = userRoles.getUser_id();
        this.profile_id = userProfile.getProfile_id();
        this.roles_id = userRoles.getRoles_id();

        this.password_current = user.getPassword_current();
        this.password_new = user.getPassword_new();
        this.password_confirm = user.getPassword_confirm();
    }


}
