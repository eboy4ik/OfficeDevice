package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.querytype.QueryTypeEnum;

import javax.servlet.http.HttpServletRequest;

public class GiveDeviceCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int queryId = Integer.parseInt(request.getParameter("queryId"));

        if (!CommandUtils.checkQueryType(request, queryId, QueryTypeEnum.GET)) {
            return null;
        }

        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        OfficeDeviceDAO officeDeviceDAO = CommandUtils.getOfficeDeviceDAO(request);
        if (CommandUtils.isFreeDevice(request, deviceId)) {
            officeDeviceDAO.giveDevice(userId, deviceId);
        }
        CommandUtils.closeQuery(request, queryId);

        return null;
    }
}
