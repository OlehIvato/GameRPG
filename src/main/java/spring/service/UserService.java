package spring.service;

import spring.model.User;
import java.util.List;

public interface UserService {

    List<User> allUsers();

    User save(User user);

    User getOneById(Long id);

    boolean createAccount(User user);

    boolean checkUsername(User user);

    boolean checkEmail(User user);

    boolean editPassword(User user);

    void deleteUser(Long userId);

}

