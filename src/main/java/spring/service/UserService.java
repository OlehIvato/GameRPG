package spring.service;

import spring.model.User;
import java.util.List;

public interface UserService {

    List<User> allUsers();

    User save(User user);

    User getOneById(Long id);

    User findUserByUsername(String username);

    User getOneByEmail(String email);

    boolean createAccount(User user);

    boolean updateUsername(Long currentUserId, User newUser);

    boolean updateEmail(User user);

    boolean updatePassword(User user);

    boolean resetPassword(User user);

    void deleteUser(String username, Long userId);

}

