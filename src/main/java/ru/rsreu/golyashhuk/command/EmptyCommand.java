package ru.rsreu.golyashhuk.command;


import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }

}
