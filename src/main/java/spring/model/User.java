package spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "t_user")
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Username entered is invalid. It must have more than 3 characters.")
    @Pattern(regexp = "([a-zA-Z0-9]*)", message = "Please provide a valid Username")
    private String username;

    @Size(min = 6, message = "Password must be over 6 characters.")
    private String password;

    @Pattern(regexp = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please provide a valid email address")
    private String email;

    @Transient
    private String password_current;

    @Transient
    @Size(min = 6, message = "Password must be over 6 characters.")
    private String password_new;

    @Transient
    @Size(min = 6, message = "Password must be over 6 characters.")
    private String password_confirm;


    @Column(name = "role_id")
    private Long role_id;

    @Transient
    @Column(name = "profile_id")
    private Long profile_id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Role role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
//    insertable = false, updatable = false
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}