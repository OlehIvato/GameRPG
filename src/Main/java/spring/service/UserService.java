package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.model.Profile;
import spring.model.Role;
import spring.model.User;
import spring.model.User_Profile;
import spring.repository.*;

import java.util.Collections;
import java.util.List;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    User_ProfileRepository user_profileRepository;
    @Autowired
    User_RolesRepository user_rolesRepository;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not Found!!!");
        }
        return user;
    }


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean createUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        User_Profile user_profile = new User_Profile();
        Profile profile = new Profile();
        if (userFromDB != null) {
            return false;
        }
        user.setRoles((Collections.singleton(new Role((long) 1, "ROLE_USER"))));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        profile.setId(user.getId());
        profileRepository.save(profile);

        user_profile.setUser_id(user.getId());
        user_profile.setProfile_id(profile.getId());
        user_profileRepository.save(user_profile);
        return true;
    }

    public User updateUser(User user) {
        return userRepository.save(user);
     }

    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }


    public User getOneById(Long id) {
        return userRepository.getOneById(id);
    }

    public User findByName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User saveUserInfo_Id(User user) {
        return userRepository.save(user);
    }

}
