package com.prokopovich.mvc.service.impl;

import com.prokopovich.mvc.dao.impl.UserDaoImpl;
import com.prokopovich.mvc.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl Instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return Instance;
    }

    @Override
    public boolean authenticate(String login, String password) {
        //return login.equals(password);
        // todo validate login, pass + md5
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = userDao.authenticate(login, password);
        return match;
    }
}
