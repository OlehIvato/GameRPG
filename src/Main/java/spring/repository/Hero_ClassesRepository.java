package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Hero_Classes;

@Repository
public interface Hero_ClassesRepository extends JpaRepository<Hero_Classes, Long> {
}
