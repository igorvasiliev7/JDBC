package jdbc.dao;

import jdbc.model.Todo;

import java.util.List;

public interface TodoDao {

    /**
     * Returns list of all Todos.
     *
     * @return {@link Todo} list.
     */
    List<Todo> findAll();

    void save(Todo todo);
}
