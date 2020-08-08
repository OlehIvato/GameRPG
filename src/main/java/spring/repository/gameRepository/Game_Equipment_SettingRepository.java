package spring.repository.gameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.gameModel.Game_Equipment_Setting_Model;

@Repository
public interface Game_Equipment_SettingRepository extends JpaRepository<Game_Equipment_Setting_Model, Long> {

}
