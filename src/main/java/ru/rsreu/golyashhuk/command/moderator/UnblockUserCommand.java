package ru.rsreu.golyashhuk.command.moderator;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.role.Role;
import ru.rsreu.golyashhuk.role.RoleConverter;
import ru.rsreu.golyashhuk.role.RoleEnum;

import javax.servlet.http.HttpServletRequest;

public class UnblockUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDataDAO userDataDAO = CommandUtils.getUserDataDAO(request);

        Role currentRole = (Role) request.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.role"));
        Role userRole = RoleConverter.getRoleByUserRoleId(userDataDAO.getUserRoleById(userId));
        if (!RoleEnum.isHigher(currentRole, userRole)) {
            return ConfigurationManager.getProperty("path.page.error.accessdenied");
        }
        userDataDAO.unblockUser(userId);
        return null;
    }
}
