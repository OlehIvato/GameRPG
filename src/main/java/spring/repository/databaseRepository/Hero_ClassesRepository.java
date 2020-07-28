package spring.repository.databaseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.databaseModel.Hero_Classes;

@Repository
public interface Hero_ClassesRepository extends JpaRepository<Hero_Classes, Long> {
}
