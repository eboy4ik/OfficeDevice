package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.role.Role;
import ru.rsreu.golyashhuk.role.RoleConverter;
import ru.rsreu.golyashhuk.role.RoleEnum;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        UserDataDAO userDataDAO = (UserDataDAO) request.getServletContext().getAttribute("UserDataDAO");
        OfficeDeviceDAO officeDeviceDAO = (OfficeDeviceDAO) request.getServletContext().getAttribute("OfficeDeviceDAO");
        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute("QueryDAO");

        Role deletingUserRole = (Role) request.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.role"));
        int deletedUserId = Integer.parseInt(request.getParameter("userId"));
        int deletedUserRoleId = userDataDAO.getUserRoleById(deletedUserId);
        Role deletedUserRole = RoleConverter.getRoleByUserRoleId(deletedUserRoleId);

        if (!RoleEnum.isHigher(deletingUserRole, deletedUserRole)) {
            return ConfigurationManager.getProperty("path.page.error.accessdenied");
        }

        officeDeviceDAO.backAllUserDevices(deletedUserId);
        queryDAO.deleteAllUserQueries(deletedUserId);
        userDataDAO.deleteUser(deletedUserId);

        return null;
    }
}
