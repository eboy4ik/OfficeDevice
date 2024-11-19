package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;

import javax.servlet.http.HttpServletRequest;

public class CreateDeviceCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        OfficeDeviceDAO officeDeviceDAO = (OfficeDeviceDAO) request.getServletContext().getAttribute("OfficeDeviceDAO");

        String name = request.getParameter("name");

        officeDeviceDAO.createDevice(name);

        return null;
    }
}
