package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.BossesModel;

@Repository
public interface BossesRepository extends JpaRepository<BossesModel, Long> {
    @Query(value = "SELECT * FROM bosses ORDER BY RAND() LIMIT 1", nativeQuery = true)
    BossesModel getOneRandomBoss();
}
