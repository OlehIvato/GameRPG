package spring.dto;

import lombok.Data;
import spring.model.Profile;
import spring.model.User;

import java.util.Date;

@Data
public class User_ProfileDto {

    private Long userID;
  private Long profileID;
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
        this.userID = user.getId();
        this.password = user.getPassword();
        this.email = user.getEmail();

        this.profileID = profile.getId();
        this.name = profile.getName();
        this.surname = profile.getSurname();
        this.birthday = profile.getBirthday();
        this.gender = profile.getGender();

        this.username = user.getUsername();
        this.phone = profile.getPhone();
        this.country = profile.getCountry();
        this.city = profile.getCity();
        this.zip = profile.getZip();
        this.bio = profile.getBio();
        this.avatar = profile.getAvatar();
    }


    public User_ProfileDto(User user ) {
        this.userID = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.password_current = user.getPassword_current();
        this.password_new = user.getPassword_new();
        this.password_confirm = user.getPassword_confirm();
    }


}
