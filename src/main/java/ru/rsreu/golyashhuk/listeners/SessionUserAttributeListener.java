package ru.rsreu.golyashhuk.listeners;

import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.role.Role;
import ru.rsreu.golyashhuk.role.RoleConverter;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionUserAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeAdded(se);
        String addedAttribute = se.getName();
        Object value = se.getValue();
        if (addedAttribute.equals(ConfigurationManager.getProperty("name.servletcontext.user"))) {
            UserDataDAO userDataDAO = (UserDataDAO) se.getSession().getServletContext().getAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.userdata"));
            int oldUserID = ((User) value).getId();
            userDataDAO.setOnlineStatus(oldUserID);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSessionAttributeListener.super.attributeReplaced(se);
        String changedAttribute = se.getName();
        Object oldValue = se.getValue();
        User newUser = (User) se.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.user"));
        String userAttribute = ConfigurationManager.getProperty("name.servletcontext.user");
        if (changedAttribute.equals(userAttribute) && newUser.getId() != ((User) (oldValue)).getId()) {
            UserDataDAO userDataDAO = (UserDataDAO) se.getSession().getServletContext().getAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.userdata"));
            int oldUserId = ((User) oldValue).getId();
            userDataDAO.setOfflineStatus(oldUserId);

            int newUserId = newUser.getId();
            userDataDAO.setOnlineStatus(newUserId);

            se.getSession().setAttribute(ConfigurationManager.getProperty("name.servletcontext.role"), RoleConverter.getRoleByUserRoleId(newUser.getRole().getId()));
        }
    }
}
