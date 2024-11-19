package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandEnum;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;

import javax.servlet.http.HttpServletRequest;

public class DeleteDeviceCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        OfficeDeviceDAO officeDeviceDAO = CommandUtils.getOfficeDeviceDAO(request);
        QueryDAO queryDAO = CommandUtils.getQueryDAO(request);

        int deviceId = Integer.parseInt(request.getParameter("deviceId"));

        queryDAO.deleteAllQueriesWithDevice(deviceId);
        officeDeviceDAO.deleteDevice(deviceId);

        return null;
    }
}
