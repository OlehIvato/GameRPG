package spring.repository.gameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.gameModel.Game_Fight_Model;

@Repository
public interface Game_FightRepository extends JpaRepository<Game_Fight_Model, String> {
    Game_Fight_Model findByUsername(String username);
}
