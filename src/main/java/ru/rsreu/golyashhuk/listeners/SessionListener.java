package ru.rsreu.golyashhuk.listeners;


import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        UserDataDAO userDataDAO = (UserDataDAO) se.getSession().getServletContext().getAttribute("UserDataDAO");
        int userId = ((User) (se.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.user")))).getId();
        userDataDAO.setOfflineStatus(userId);
    }
}
