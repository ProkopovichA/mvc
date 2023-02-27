package com.prokopovich.mvc.command.impl;

import com.prokopovich.mvc.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "index.jsp";
    }
}

