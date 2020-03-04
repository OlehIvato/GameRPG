package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
