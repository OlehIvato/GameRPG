package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.User_Profile;

@Repository
public interface User_ProfileRepository extends JpaRepository<User_Profile, Long> {
}
