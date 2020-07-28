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

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ProfileServiceImp profileServiceImp;
    private final User_ProfileRepository user_profileRepository;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_CreatureRepository gameCreatureRepository;
    private final Game_LocationRepository gameLocationRepository;
    private final Game_FightRepository gameFightRepository;
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
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            return false;
        }
        User_Profile user_profile = new User_Profile();
        Profile profile = new Profile();
        Game_Hero_Model game_hero_model = new Game_Hero_Model();
        Game_Location_Model game_location_model = new Game_Location_Model();
        Game_Creature_Model game_creature_model = new Game_Creature_Model();
        Game_Fight_Model game_fight_model = new Game_Fight_Model();

        user.setRoles((Collections.singleton(new Role((long) 3, "ROLE_USER")))); //role 3 (user), role name
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        logger.info("Created role and encode password for new User");

        userRepository.save(user);
        logger.info("User table: added new User: " + user.getUsername());

        profile.setId(user.getId());
        profileServiceImp.save(profile);
        logger.info("Added Profile row for User: " + user.getUsername());

        user_profile.setUser_id(user.getId());
        user_profile.setProfile_id(profile.getId());
        user_profileRepository.save(user_profile);
        logger.info("Profile table: binding to the User table for User: " + user.getUsername());

        game_creature_model.setUsername(user.getUsername());
        gameCreatureRepository.save(game_creature_model);
        logger.info("Game_Creature table: binding to the User table for User: " + user.getUsername());

        game_hero_model.setUsername(user.getUsername());
        gameHeroRepository.save(game_hero_model);
        logger.info("Game_Hero table: binding to the User table for User: " + user.getUsername());

        game_location_model.setUsername(user.getUsername());
        gameLocationRepository.save(game_location_model);
        logger.info("Game_Location table: binding to the Users table for User: " + user.getUsername());

        game_fight_model.setUsername(user.getUsername());
        gameFightRepository.save(game_fight_model);
        logger.info("Game_Fight table: binding to the User table for User: " + user.getUsername());
        return true;
    }


    @Override
    public boolean updatePassword(User user) {
        if (!bCryptPasswordEncoder.matches(user.getPassword_current(), user.getPassword())
                || !user.getPassword_new().equals(user.getPassword_confirm())) {
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword_new()));
        userRepository.save(user);
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
        userRepository.save(userFromDatabase);
        logger.info("User: " + user.getUsername() + " reset his password");
        return true;
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getOneById(Long id) {
        return userRepository.getOneById(id);
    }

    @Override
    public User getOneByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean updateUsername(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        return userFromDB == null;
    }

    @Override
    public boolean updateEmail(User user) {
        User userFromDB = userRepository.findByEmail(user.getEmail());
        return userFromDB == null;
    }

    @Override
    public void deleteUser(String username, Long userId) {
        Game_Location_Model game_location_model = gameLocationRepository.findByUsername(username);
        Game_Hero_Model game_hero_model = gameHeroRepository.findByUsername(username);
        Game_Creature_Model game_creature_model = gameCreatureRepository.findByUsername(username);
        Game_Fight_Model game_fight_model = gameFightRepository.findByUsername(username);

        userRepository.deleteById(userId);
        logger.info("Deleted " + username + " from User table");

        profileServiceImp.deleteById(userId);
        logger.info("Deleted bind from Profile table for User: " + username);

        gameLocationRepository.delete(game_location_model);
        logger.info("Deleted bind from Game_Location table for User: " + username);

        gameHeroRepository.delete(game_hero_model);
        logger.info("Deleted bind from Game_Hero table for User: " + username);

        gameCreatureRepository.delete(game_creature_model);
        logger.info("Deleted bind from Game_Creature table for User: " + username);

        gameFightRepository.delete(game_fight_model);
        logger.info("Deleted bind from Game_Fight table for User: " + username);
    }
}
