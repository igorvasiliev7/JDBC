package jdbc.dao.factory;

import jdbc.dao.TodoDao;
import jdbc.dao.UserDao;
import jdbc.dao.impl.TodoDaoImpl;
import jdbc.dao.impl.UserDaoImpl;

public class DaoFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static TodoDao getTodoDao() {
        return new TodoDaoImpl();
    }
}
