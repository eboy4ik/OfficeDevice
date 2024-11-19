package ru.rsreu.golyashhuk.command.general;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.role.Role;
import ru.rsreu.golyashhuk.role.RoleConverter;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final Resourcer resourcer = ProjectResourcer.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter("login");

        String pass = request.getParameter("password");
        UserDataDAO userDataDAO = (UserDataDAO) request.getServletContext().getAttribute("UserDataDAO");

        User user = userDataDAO.getUser(login, pass);

        if (user.isValid() && !user.getIsBlocked()) {
            page = ConfigurationManager.getProperty("path.page.main");
            request.getSession(true).setAttribute("user", user);
            Role role = RoleConverter.getRoleByUserRoleId(user.getRole().getId());
            request.getSession().setAttribute(ConfigurationManager.getProperty("name.servletcontext.role"), role);
            request.getSession().setAttribute(ConfigurationManager.getProperty("name.servletcontext.userheader"), role.getHeader());
        } else {
            request.getSession(false).setAttribute("errorLoginPassMessage", resourcer.getString("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }

}
