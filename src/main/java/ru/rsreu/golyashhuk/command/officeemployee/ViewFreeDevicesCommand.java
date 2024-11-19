package ru.rsreu.golyashhuk.command.officeemployee;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.entities.OfficeDevice;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewFreeDevicesCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Доступная техника");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.officeemployee.devices"));

        OfficeDeviceDAO officeDeviceDAO = (OfficeDeviceDAO) request.getServletContext().getAttribute("OfficeDeviceDAO");

        List<OfficeDevice> officeDevices = officeDeviceDAO.getFreeOfficeDevices();
        request.setAttribute("devicesList", officeDevices);

        return ConfigurationManager.getProperty("path.page.main");
    }
}
