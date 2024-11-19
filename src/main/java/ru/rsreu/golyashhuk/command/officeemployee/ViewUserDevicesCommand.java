package ru.rsreu.golyashhuk.command.officeemployee;


import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.entities.OfficeDevice;
import ru.rsreu.golyashhuk.datalayer.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewUserDevicesCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Пользователи");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.officeemployee.userdevices"));

        OfficeDeviceDAO officeDeviceDAO = (OfficeDeviceDAO) request.getServletContext().getAttribute("OfficeDeviceDAO");

        int userId = ((User) (request.getSession().getAttribute("user"))).getId();
        List<OfficeDevice> officeDevices = officeDeviceDAO.getUserOfficeDevices(userId);
        request.setAttribute("devicesList", officeDevices);

        return ConfigurationManager.getProperty("path.page.main");
    }
}
