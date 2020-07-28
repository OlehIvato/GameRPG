package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.Equipment_Types;

@Repository
public interface Equipment_TypesRepository extends JpaRepository<Equipment_Types, Long> {
}
