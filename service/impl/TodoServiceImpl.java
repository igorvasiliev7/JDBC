package jdbc.service.impl;

import jdbc.dao.factory.DaoFactory;
import jdbc.model.Todo;
import jdbc.service.TodoService;

import java.util.List;

public class TodoServiceImpl implements TodoService {

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Todo> findAll() {
        return DaoFactory.getTodoDao().findAll();
    }

    @Override
    public void save(Todo todo) {
        DaoFactory.getTodoDao().save(todo);
    }
}
