package ru.rsreu.golyashhuk.command.admin;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;
import ru.rsreu.golyashhuk.datalayer.entities.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewQueriesCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Запросы");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.sysadmin.queries"));

        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute("QueryDAO");

        List<Query> queriesList = queryDAO.getAllQueries();
        request.setAttribute("queriesList", queriesList);

        return ConfigurationManager.getProperty("path.page.main");
    }
}
