package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
