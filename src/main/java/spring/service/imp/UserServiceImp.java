package spring.service.imp;

import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.model.*;
import spring.model.gameModel.Game_Creature_Model;
import spring.model.gameModel.Game_Fight_Model;
import spring.model.gameModel.Game_Hero_Model;
import spring.model.gameModel.Game_Location_Model;
import spring.repository.*;
import spring.repository.gameRepository.Game_CreatureRepository;
import spring.repository.gameRepository.Game_FightRepository;
import spring.repository.gameRepository.Game_HeroRepository;
import spring.repository.gameRepository.Game_LocationRepository;
import spring.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_CreatureRepository gameCreatureRepository;
    private final Game_LocationRepository gameLocationRepository;
    private final Game_FightRepository gameFightRepository;
    private final ProfileRepository profileRepository;
    private static final Logger logger = Logger.getLogger(UserServiceImp.class.getName());


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Optional.ofNullable(user).isEmpty()) {
            logger.error("User tried to get a username [" + username + "] which doesn't exist");
        }
        if (Optional.ofNullable(userRepository.findByUsername(username).getUsername())
                .equals(Optional.ofNullable(userRepository.findByUsername(username).getUsername()))) {
            logger.info("User " + username + " is logged in");
        }
        return user;
    }

    @Override
    public boolean createAccount(User user) {
        Optional<User> userFromDatabase = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (userFromDatabase.isPresent()) {
            return false;
        }
        user.setRole(new Role((long) 3, "ROLE_USER"));
        user.setProfile(new Profile(user.getUsername()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole_id(user.getRole().getId());

        userRepository.save(user);
        gameCreatureRepository.save(new Game_Creature_Model(user.getUsername()));
        gameHeroRepository.save(new Game_Hero_Model(user.getUsername()));
        gameLocationRepository.save(new Game_Location_Model(user.getUsername()));
        gameFightRepository.save(new Game_Fight_Model(user.getUsername()));
        logger.info("User table: added new User: " + user.getUsername());
        return true;
    }

    @Override
    public boolean updatePassword(User user) {
        if (!bCryptPasswordEncoder.matches(user.getPassword_current(), user.getPassword())
                || !user.getPassword_new().equals(user.getPassword_confirm())) {
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword_new()));
        save(user);
        logger.info("User: " + user.getUsername() + " changed his password");
        return true;
    }

    @Override
    public boolean resetPassword(User user) {
        User userFromDatabase = userRepository.findByEmail(user.getEmail());
        if (!user.getPassword_new().equals(user.getPassword_confirm())) {
            return false;
        }
        userFromDatabase.setPassword(bCryptPasswordEncoder.encode(user.getPassword_new()));
        save(userFromDatabase);
        logger.info("User: " + user.getUsername() + " reset his password");
        return true;
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        User userFromDatabase = (userRepository.findByUsername(user.getUsername()));

        if (Optional.ofNullable(user.getId()).isEmpty()) {
            user.setId(userFromDatabase.getId());
        }
        if (Optional.ofNullable(user.getUsername()).isEmpty()) {
            user.setUsername(userFromDatabase.getUsername());
        }
        if (Optional.ofNullable(user.getPassword()).isEmpty()) {
            user.setPassword(userFromDatabase.getPassword());
        }
        if (Optional.ofNullable(user.getEmail()).isEmpty()) {
            user.setEmail(userFromDatabase.getEmail());
        }
        if (Optional.ofNullable(user.getRole_id()).isEmpty()) {
            user.setRole_id(userFromDatabase.getRole_id());
        }
        if (Optional.ofNullable(user.getProfile_id()).isEmpty()) {
            user.setProfile_id(userFromDatabase.getProfile_id());
        }
        user.setProfile(userFromDatabase.getProfile());
        return userRepository.save(user);
    }

    @Override
    public User getOneById(Long id) {
        return userRepository.getOneById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getOneByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean updateUsername(Long currentUserId, User newUser) {
        if (Optional.ofNullable(userRepository.findByUsername(newUser.getUsername())).isPresent()) {
            return false;
        }
        User user = userRepository.getOneById(currentUserId);
        String currentUsername = user.getUsername();

        user.setUsername(newUser.getUsername());
        userRepository.save(user);

        Profile profile = profileRepository.findByUsername(currentUsername);
        Game_Creature_Model game_creature_model = gameCreatureRepository.findByUsername(currentUsername);
        Game_Fight_Model game_fight_model = gameFightRepository.findByUsername(currentUsername);
        Game_Hero_Model game_hero_model = gameHeroRepository.findByUsername(currentUsername);
        Game_Location_Model game_location_model = gameLocationRepository.findByUsername(currentUsername);

        profile.setUsername(newUser.getUsername());
        game_creature_model.setUsername(newUser.getUsername());
        game_fight_model.setUsername(newUser.getUsername());
        game_hero_model.setUsername(newUser.getUsername());
        game_location_model.setUsername(newUser.getUsername());

        profileRepository.save(profile);
        gameCreatureRepository.save(game_creature_model);
        gameFightRepository.save(game_fight_model);
        gameHeroRepository.save(game_hero_model);
        gameLocationRepository.save(game_location_model);
        return true;
    }

    @Override
    public boolean updateEmail(User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());
        return userFromDB == null;
    }

    @Override
    public void deleteUser(String username, Long userId) {
        userRepository.deleteById(userId);
        gameLocationRepository.delete(gameLocationRepository.findByUsername(username));
        gameHeroRepository.delete(gameHeroRepository.findByUsername(username));
        gameCreatureRepository.delete(gameCreatureRepository.findByUsername(username));
        gameFightRepository.delete(gameFightRepository.findByUsername(username));
    }

}

