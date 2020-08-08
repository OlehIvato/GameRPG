package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.Armor;

@Repository
public interface ArmorRepository extends JpaRepository<Armor, Long> {
}
