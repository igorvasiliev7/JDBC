package jdbc.dao.impl;

import jdbc.dao.TodoDao;
import jdbc.datasource.DatabaseSource;
import jdbc.model.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    private static final String SELECT_ALL = "select * from todo;";
    private static final String INSERT = "INSERT INTO todo (name, user_id) VALUES (?,?)";

    /**
     * {@inheritDoc}.
     */
    @Override
    public List<Todo> findAll() {
        List<Todo> todos = new LinkedList<>();
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Todo todo = new Todo();
                todo.setId(resultSet.getLong("id"));
                todo.setUserId(resultSet.getLong("user_id"));
                todo.setName(resultSet.getString("name"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public void save(Todo todo) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, todo.getName());
            preparedStatement.setLong(2, todo.getUserId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
