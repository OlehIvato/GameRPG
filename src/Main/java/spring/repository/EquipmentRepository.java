package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.EquipmentModel;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentModel, Long> {

    List<EquipmentModel> findAllByName(String name);



}
