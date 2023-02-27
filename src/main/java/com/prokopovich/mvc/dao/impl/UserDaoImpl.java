package com.prokopovich.mvc.dao.impl;

import com.prokopovich.mvc.dao.BaseDao;
import com.prokopovich.mvc.dao.UserDao;
import com.prokopovich.mvc.entity.User;
import org.intellij.lang.annotations.Language;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private static final String SELECT_LOGIN_PASSWORD = "SELECT password FROM users WHERE lastname = ?";
    private static UserDaoImpl instance = new UserDaoImpl();
    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mvc_base";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "Root_123");
        boolean match = false;

        try (Connection connection = DriverManager.getConnection(url, prop);
             PreparedStatement statement = connection.prepareStatement(SELECT_LOGIN_PASSWORD)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            String passFromDb;
            if (resultSet.next()) {
                passFromDb = resultSet.getString(1);
                match = password.equals(passFromDb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return match;
    }
}
