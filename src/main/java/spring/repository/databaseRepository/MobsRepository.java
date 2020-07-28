package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.MobsModel;

@Repository
public interface MobsRepository extends JpaRepository<MobsModel, Long> {

    @Query(value = "SELECT * FROM mobs ORDER BY RAND() LIMIT 1", nativeQuery = true)
    MobsModel getOneRandomMob();
}
