package spring.repository.gameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.model.gameModel.Game_Location_Model;

@Repository
public interface Game_LocationRepository extends JpaRepository<Game_Location_Model, String> {
    Game_Location_Model findByUsername(String username);
}
