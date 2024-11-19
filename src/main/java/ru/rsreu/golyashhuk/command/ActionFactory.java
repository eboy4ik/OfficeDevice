package ru.rsreu.golyashhuk.command;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;


import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static Resourcer resourcer = ProjectResourcer.getInstance();

    public static ActionCommand defineCommand(HttpServletRequest request) {

        ActionCommand current = new EmptyCommand();

        String action = request.getParameter("command");

        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + resourcer.getString("message.wrongaction"));
        }
        return current;
    }
}
