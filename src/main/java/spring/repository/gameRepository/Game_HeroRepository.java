package spring.repository.gameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.gameModel.Game_Hero_Model;
import spring.model.gameModel.Game_Location_Model;

@Repository
public interface Game_HeroRepository extends JpaRepository<Game_Hero_Model, String> {
    Game_Hero_Model findByUsername(String username);
}