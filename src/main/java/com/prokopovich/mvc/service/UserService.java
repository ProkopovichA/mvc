package com.prokopovich.mvc.service;

public interface UserService {
    boolean authenticate(String login, String password);
}
