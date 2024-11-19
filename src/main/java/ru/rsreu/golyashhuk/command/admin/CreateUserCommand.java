package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.role.Role;
import ru.rsreu.golyashhuk.role.RoleConverter;
import ru.rsreu.golyashhuk.role.RoleEnum;

import javax.servlet.http.HttpServletRequest;

public class CreateUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        UserDataDAO userDataDAO = (UserDataDAO) request.getServletContext().getAttribute("UserDataDAO");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter(ConfigurationManager.getProperty("name.servletcontext.role"));

        int roleId = RoleConverter.getUserRoleIdByRole(RoleConverter.getRoleByString(role));
        userDataDAO.createUser(login, password, name, roleId);

        return null;
    }
}
