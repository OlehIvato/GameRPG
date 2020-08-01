package spring.repository.gameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.gameModel.Game_Creature_Model;



@Repository
public interface Game_CreatureRepository extends JpaRepository<Game_Creature_Model, String> {
    Game_Creature_Model findByUsername(String username);

}

