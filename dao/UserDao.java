package jdbc.dao;

import jdbc.model.User;

import java.util.List;

public interface UserDao {

    /**
     * Returns list of all users.
     *
     * @return {@link User} list.
     */
    List<User> findAll();

    void save(User user);
}
