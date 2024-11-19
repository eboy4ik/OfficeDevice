package ru.rsreu.golyashhuk.command.admin;


import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;


import javax.servlet.http.HttpServletRequest;

public class ViewDevicesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Устройства");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.sysadmin.devices"));

        OfficeDeviceDAO officeDeviceDAO = (OfficeDeviceDAO) request.getServletContext().getAttribute("OfficeDeviceDAO");

        request.setAttribute("devicesList", officeDeviceDAO.getAllOfficeDevices());
        return ConfigurationManager.getProperty("path.page.main");
    }
}
