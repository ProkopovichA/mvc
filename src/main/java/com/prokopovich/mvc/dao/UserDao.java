package com.prokopovich.mvc.dao;

public interface UserDao {
    boolean authenticate(String login, String password);
}
