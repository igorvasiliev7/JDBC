package jdbc.service;

import jdbc.model.User;

import java.util.List;

public interface UserService {

    /**
     * Returns list of all users.
     *
     * @return {@link User} list.
     */
    List<User> findAll();

    void save(User user);
}
