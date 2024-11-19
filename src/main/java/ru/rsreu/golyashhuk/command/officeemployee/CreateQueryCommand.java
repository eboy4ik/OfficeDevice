package ru.rsreu.golyashhuk.command.officeemployee;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class CreateQueryCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute("QueryDAO");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        String queryType = request.getParameter("queryType");
        int queryTypeId = -1;
        switch (queryType) {
            case "get":
                queryTypeId = 1;
                break;
            case "repair":
                queryTypeId = 2;
                break;
            case "return":
                queryTypeId = 3;
                break;
        }
        String message = request.getParameter("message");
        System.out.println(message);
        queryDAO.createQuery(userId, deviceId, queryTypeId, message);
//        return ConfigurationManager.getProperty("path.page.main");
        return null;
    }
}
