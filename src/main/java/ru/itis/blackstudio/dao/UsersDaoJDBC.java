package ru.itis.blackstudio.dao;

import ru.itis.blackstudio.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDaoJDBC implements UsersDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.client;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.client WHERE id_client = ?";

    //language=SQL
    private final String SQL_SELECT_BY_USERNAME =
            "SELECT * FROM black_studio.client WHERE username = ?";

    private Connection connection;

    public UsersDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<User> rowMapper = resultSet -> {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new User(id, username, password);
    };

    public Optional<User> findById(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(rowMapper.rowMap(resultSet));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<User> findByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_USERNAME);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(rowMapper.rowMap(resultSet));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(User model) {

    }

    @Override
    public List<User> findAll() {
        try {
            List<User> users = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                User user = new User(id, username, password);

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


}
