package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
