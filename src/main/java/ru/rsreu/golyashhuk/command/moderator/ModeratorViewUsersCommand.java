package ru.rsreu.golyashhuk.command.moderator;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ModeratorViewUsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Пользователи");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.moderator.users"));

        UserDataDAO userDataDAO = CommandUtils.getUserDataDAO(request);

        List<User> userList = userDataDAO.getUsers();
        request.setAttribute("usersList", userList);
        return ConfigurationManager.getProperty("path.page.main");
    }
}
