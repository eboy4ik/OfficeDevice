package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.querytype.QueryTypeEnum;

import javax.servlet.http.HttpServletRequest;

public class AcceptDeviceCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int queryId = Integer.parseInt(request.getParameter("queryId"));

        if (!CommandUtils.checkQueryType(request, queryId, QueryTypeEnum.RETURN)) {
            return null;
        }

        int deviceId = Integer.parseInt(request.getParameter("deviceId"));

        OfficeDeviceDAO officeDeviceDAO = CommandUtils.getOfficeDeviceDAO(request);
        officeDeviceDAO.backDevice(deviceId);
        CommandUtils.closeQuery(request, queryId);

        return null;
    }
}
