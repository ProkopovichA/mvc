package com.prokopovich.mvc.command.impl;

import com.prokopovich.mvc.command.Command;
import com.prokopovich.mvc.service.UserService;
import com.prokopovich.mvc.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login"); //todo class RequestParameterName
        String password = request.getParameter("pass");
        UserService userService = UserServiceImpl.getInstance();
        String page;
       if(userService.authenticate(login, password)) {
           request.setAttribute("user", login); //todo class RequestAttributeName
           page = "pages/main.jsp"; //todo class page path
       } else {
           request.setAttribute("login_msg", "incorrect login or pass");
           page = "index.jsp"; //todo class page path
       }
        return page;
    }
}
