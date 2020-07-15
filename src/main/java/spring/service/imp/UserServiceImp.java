package spring.service.imp;

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


@Service
public class UserServiceImp implements UserService, UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ProfileServiceImp profileServiceImp;
    private final User_ProfileRepository user_profileRepository;
    private final Game_HeroRepository gameHeroRepository;
    private final Game_CreatureRepository gameCreatureRepository;
    private final Game_LocationRepository gameLocationRepository;
    private final Game_FightRepository gameFightRepository;

    public UserServiceImp(BCryptPasswordEncoder bCryptPasswordEncoder,
                          UserRepository userRepository, ProfileServiceImp profileServiceImp,
                          User_ProfileRepository user_profileRepository,
                          Game_HeroRepository gameHeroRepository,
                          Game_CreatureRepository gameCreatureRepository,
                          Game_LocationRepository gameLocationRepository,
                          Game_FightRepository gameFightRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.profileServiceImp = profileServiceImp;
        this.user_profileRepository = user_profileRepository;
        this.gameHeroRepository = gameHeroRepository;
        this.gameCreatureRepository = gameCreatureRepository;
        this.gameLocationRepository = gameLocationRepository;
        this.gameFightRepository = gameFightRepository;
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
        Game_Hero_Model game_hero_model = new Game_Hero_Model();
        Game_Location_Model game_location_model = new Game_Location_Model();
        Game_Creature_Model game_creature_model = new Game_Creature_Model();
        Game_Fight_Model game_fight_model = new Game_Fight_Model();
        if (userFromDB != null) {
            return false;
        }

        user.setRoles((Collections.singleton(new Role((long) 3, "ROLE_USER")))); //role 3 (user), role name
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        profile.setId(user.getId());
        profileServiceImp.save(profile);

        user_profile.setUser_id(user.getId());
        user_profile.setProfile_id(profile.getId());
        user_profileRepository.save(user_profile);

        game_creature_model.setUsername(user.getUsername());
        gameCreatureRepository.save(game_creature_model);
        game_hero_model.setUsername(user.getUsername());
        gameHeroRepository.save(game_hero_model);
        game_location_model.setUsername(user.getUsername());
        gameLocationRepository.save(game_location_model);
        game_fight_model.setUsername(user.getUsername());
        gameFightRepository.save(game_fight_model);
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
        profileServiceImp.deleteById(userId);
        gameLocationRepository.delete(game_location_model);
        gameHeroRepository.delete(game_hero_model);
        gameCreatureRepository.delete(game_creature_model);
        gameFightRepository.delete(game_fight_model);

    }
}
