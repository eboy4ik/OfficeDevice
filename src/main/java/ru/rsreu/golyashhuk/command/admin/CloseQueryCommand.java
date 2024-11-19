package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;

import javax.servlet.http.HttpServletRequest;

public class CloseQueryCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute("QueryDAO");

        String response = request.getParameter("response");
        int queryId = Integer.parseInt(request.getParameter("queryId"));
        queryDAO.closeQuery(queryId, response);

        return null;
    }
}
