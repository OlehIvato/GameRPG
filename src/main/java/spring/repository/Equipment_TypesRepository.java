package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Equipment_Types;

@Repository
public interface Equipment_TypesRepository extends JpaRepository<Equipment_Types, Long> {
}
