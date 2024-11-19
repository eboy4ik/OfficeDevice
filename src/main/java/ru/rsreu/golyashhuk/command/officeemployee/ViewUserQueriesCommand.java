package ru.rsreu.golyashhuk.command.officeemployee;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.DAOFactory;
import ru.rsreu.golyashhuk.datalayer.DBType;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;
import ru.rsreu.golyashhuk.datalayer.entities.OfficeDevice;
import ru.rsreu.golyashhuk.datalayer.entities.Query;
import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.datalayer.oracledb.OracleDbDAOFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewUserQueriesCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("pageTitle", "Запросы");
        request.setAttribute("contentPage", ConfigurationManager.getProperty("path.page.home.officeemployee.userqueries"));

        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute("QueryDAO");

        int userId = ((User) (request.getSession().getAttribute("user"))).getId();
        List<Query> queriesList = queryDAO.getUserQueries(userId);
        request.setAttribute("queriesList", queriesList);

        return ConfigurationManager.getProperty("path.page.main");
    }
}
