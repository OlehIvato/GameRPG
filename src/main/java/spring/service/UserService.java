package spring.service;

import spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> allUsers();

    User save(User user);

    User getOneById(Long id);

    boolean createAccount(User user);

    boolean updateUsername(User user);

    boolean updateEmail(User user);

    boolean updatePassword(User user);

    void deleteUser(String username,Long userId);
}

