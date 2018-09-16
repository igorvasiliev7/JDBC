package jdbc.service.factory;

import jdbc.service.TodoService;
import jdbc.service.UserService;
import jdbc.service.impl.TodoServiceImpl;
import jdbc.service.impl.UserServiceImpl;

public class ServiceFactory {

    public static UserService getUserService() {
        return new UserServiceImpl();
    }

    public static TodoService getTodoService() {
        return new TodoServiceImpl();
    }
}
