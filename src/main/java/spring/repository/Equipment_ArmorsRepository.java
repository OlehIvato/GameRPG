package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Equipment_Armors;

@Repository
public interface Equipment_ArmorsRepository extends JpaRepository<Equipment_Armors, Long> {
}
