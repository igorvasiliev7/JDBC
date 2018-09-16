package jdbc.demo;

import jdbc.dao.TodoDao;
import jdbc.dao.UserDao;
import jdbc.dao.factory.DaoFactory;
import jdbc.dao.impl.TodoDaoImpl;
import jdbc.dao.impl.UserDaoImpl;
import jdbc.model.Todo;
import jdbc.model.User;
import jdbc.service.TodoService;
import jdbc.service.factory.ServiceFactory;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        UserDao userDao = DaoFactory.getUserDao();
//
//        final User user = new User();
//        user.setName("Java User");
//        user.setEmail("java email");
//        user.setAge(22);
//
//        userDao.save(uy);
//
//        final List<User> users = userDao.findAll();
//        for (User elem : users) {
//            System.out.println(elem.toString());
//        }

        final TodoService todoService = ServiceFactory.getTodoService();

        final Todo todo = new Todo();
        todo.setName("Play");
        todo.setUserId(1L);
        todoService.save(todo);

        final List<Todo> todos = todoService.findAll();

        for (Todo elem : todos) {
            System.out.println(elem.toString());

        }
    }
}
