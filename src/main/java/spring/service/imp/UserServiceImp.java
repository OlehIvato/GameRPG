package spring.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import spring.service.UserService;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ProfileRepository profileRepository;
    private final User_ProfileRepository user_profileRepository;


    public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                          ProfileRepository profileRepository, User_ProfileRepository user_profileRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.profileRepository = profileRepository;
        this.user_profileRepository = user_profileRepository;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!!!");
        }
        return user;
    }

    @Override
    public boolean createAccount(User user) {
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

    @Override
    public boolean editPassword(User user) {
        if (!bCryptPasswordEncoder.matches(user.getPassword_current(), user.getPassword())
                || !user.getPassword_new().equals(user.getPassword_confirm())) {
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword_new()));
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getOneById(Long id) {
        return userRepository.getOneById(id);
    }

    @Override
    public boolean checkUsername(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        return userFromDB == null;
    }

    @Override
    public boolean checkEmail(User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());
        return userFromDB == null;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
