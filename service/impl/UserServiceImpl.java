package jdbc.service.impl;

import jdbc.dao.factory.DaoFactory;
import jdbc.model.User;
import jdbc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<User> findAll() {
        return DaoFactory.getUserDao().findAll();
    }

    @Override
    public void save(User user) {
        DaoFactory.getUserDao().save(user);
    }
}
