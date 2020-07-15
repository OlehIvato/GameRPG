package spring.repository.gameRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.gameModel.Game_SettingModel;

@Repository
public interface Game_SettingRepository extends JpaRepository<Game_SettingModel, Long> {
}
