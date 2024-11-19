package ru.rsreu.golyashhuk.listeners;

import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.DAOFactory;
import ru.rsreu.golyashhuk.datalayer.DBType;
import ru.rsreu.golyashhuk.datalayer.oracledb.OracleDbDAOFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);

        DAOFactory factory = OracleDbDAOFactory.getInstance(DBType.ORACLE);
        sce.getServletContext().setAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.userdata"), factory.getUserPasswordDAO());
        sce.getServletContext().setAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.officedevice"), factory.getOfficeDeviceDAO());
        sce.getServletContext().setAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.query"), factory.getQueryDAO());
    }
}
