package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import spring.model.HeroModel;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<HeroModel, Long> {
}

