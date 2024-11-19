package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.querytype.QueryTypeEnum;

import javax.servlet.http.HttpServletRequest;

public class RefuseRepairDeviceCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        int queryId = Integer.parseInt(request.getParameter("queryId"));

        if (!CommandUtils.checkQueryType(request, queryId, QueryTypeEnum.REPAIR)) {
            return null;
        }

        CommandUtils.closeQuery(request, queryId);
        return null;
    }
}
