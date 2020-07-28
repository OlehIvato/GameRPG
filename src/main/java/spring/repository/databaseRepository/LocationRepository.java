package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.LocationModel;

@Repository
public interface LocationRepository extends JpaRepository <LocationModel,Long> {
}
