package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User getOneById(Long id);

    User findByEmail(String email);

//    @Transactional
//    @Modifying
//    @Query(value = "update t_user set role_id  = ? where id = ?", nativeQuery = true)
//    void updateRoleId(Long role_id, Long user_id);

}
