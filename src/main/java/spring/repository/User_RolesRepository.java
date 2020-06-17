package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.User_Roles;

@Repository
public interface User_RolesRepository extends JpaRepository<User_Roles, Long> {
}
