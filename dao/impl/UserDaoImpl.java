package jdbc.dao.impl;

import jdbc.dao.UserDao;
import jdbc.datasource.DatabaseSource;
import jdbc.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl implements UserDao {

    private static final String SELECT_ALL = "select * from users;";
    private static final String INSERT = "INSERT INTO users(name, email, age) VALUES (?,?,?)";

    /**
     * {@inheritDoc}.
     */
    public List<User> findAll() {
        List<User> users = new LinkedList<>();
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
