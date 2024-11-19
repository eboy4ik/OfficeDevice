package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.UserRole;
import ru.rsreu.golyashhuk.role.Role;
import ru.rsreu.golyashhuk.role.RoleConverter;
import ru.rsreu.golyashhuk.role.RoleEnum;

import javax.servlet.http.HttpServletRequest;

public class EditUserCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        UserDataDAO userDataDAO = (UserDataDAO) request.getServletContext().getAttribute("UserDataDAO");

        Role editingUserRole = (Role) request.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.role"));
        int editedUserId = Integer.parseInt(request.getParameter("userId"));
        int editedUserRoleId = userDataDAO.getUserRoleById(editedUserId);
        Role editedUserRole = RoleConverter.getRoleByUserRoleId(editedUserRoleId);
        int newRoleId = editedUserRoleId;
        if (!RoleEnum.isHigher(editingUserRole, editedUserRole)) {
            return ConfigurationManager.getProperty("path.page.error.accessdenied");
        }
        String newName = request.getParameter("name");
        String newRoleString = request.getParameter(ConfigurationManager.getProperty("name.servletcontext.role"));
        Role newRole = RoleConverter.getRoleByString(newRoleString);
        if (newRole != RoleEnum.NULL) {
            newRoleId = RoleConverter.getUserRoleIdByRole(newRole);
        }
        userDataDAO.editUserData(editedUserId, newName, newRoleId);

        return null;
    }
}
