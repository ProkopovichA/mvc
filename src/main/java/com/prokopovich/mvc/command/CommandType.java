package com.prokopovich.mvc.command;

import com.prokopovich.mvc.command.impl.AddUserCommand;
import com.prokopovich.mvc.command.impl.DefaultCommand;
import com.prokopovich.mvc.command.impl.LoginCommand;
import com.prokopovich.mvc.command.impl.LogoutCommand;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand());
    Command command;
    CommandType(Command command) {
        this.command = command;
    }
    public static Command define(String commandStr){
       CommandType current = CommandType.valueOf(commandStr.toUpperCase());
       return current.command;
    }
}
