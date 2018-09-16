package jdbc.service;

import jdbc.model.Todo;

import java.util.List;

public interface TodoService {

    /**
     * Returns list of all Todos.
     *
     * @return {@link Todo} list.
     */
    List<Todo> findAll();

    void save(Todo todo);
}
