package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.LocationModel;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository <LocationModel,Long> {
    List<LocationModel> findAllByName(String name);

}
