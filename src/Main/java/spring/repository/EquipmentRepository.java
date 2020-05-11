package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.EquipmentModel;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentModel, Long> {

    List<EquipmentModel> findAllByName(String name);

}
