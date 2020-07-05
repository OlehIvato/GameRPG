package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Hero_Armors;

@Repository
public interface Hero_ArmorsRepository extends JpaRepository<Hero_Armors, Long> {
}
