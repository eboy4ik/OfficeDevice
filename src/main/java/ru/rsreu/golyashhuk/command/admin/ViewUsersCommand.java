package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewUsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Пользователи");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.admin.users"));

        UserDataDAO userPasswordDAO = (UserDataDAO) request.getServletContext().getAttribute("UserDataDAO");

        List<User> userList = userPasswordDAO.getUsers();
        request.setAttribute("usersList", userList);
        return ConfigurationManager.getProperty("path.page.main");
    }
}
