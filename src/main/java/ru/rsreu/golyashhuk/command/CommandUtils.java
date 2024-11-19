package ru.rsreu.golyashhuk.command;

import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.OfficeDeviceDAO;
import ru.rsreu.golyashhuk.datalayer.QueryDAO;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.Query;
import ru.rsreu.golyashhuk.querytype.QueryTypeConverter;
import ru.rsreu.golyashhuk.querytype.QueryTypeEnum;

import javax.servlet.http.HttpServletRequest;

public class CommandUtils {
    private CommandUtils() {
    }

    public static UserDataDAO getUserDataDAO(HttpServletRequest request) {
        return (UserDataDAO) request.getServletContext().getAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.userdata"));
    }

    public static OfficeDeviceDAO getOfficeDeviceDAO(HttpServletRequest request) {
        return (OfficeDeviceDAO) request.getServletContext().getAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.officedevice"));
    }

    public static QueryDAO getQueryDAO(HttpServletRequest request) {
        return (QueryDAO) request.getServletContext().getAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.query"));
    }

    public static boolean checkQueryType(HttpServletRequest request, int queryId, QueryTypeEnum queryType) {
        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute(ConfigurationManager.getProperty("name.servletcontext.dao.query"));
        Query query = queryDAO.getQuery(queryId);
        return query.getQueryType().getId() == QueryTypeConverter.getIdByQueryType(queryType);

    }

    public static void closeQuery(HttpServletRequest request, int queryId) {
        QueryDAO queryDAO = (QueryDAO) request.getServletContext().getAttribute("QueryDAO");

        String response = request.getParameter("response");
        queryDAO.closeQuery(queryId, response);
    }

    public static boolean isFreeDevice(HttpServletRequest request, int deviceId) {
        OfficeDeviceDAO officeDeviceDAO = CommandUtils.getOfficeDeviceDAO(request);
        return officeDeviceDAO.getDeviceUser(deviceId) <= 0;
    }

    public static void updateLastURL(HttpServletRequest request) {
        String lastUrl = CommandUtils.getUrlFromRequest(request);
        request.getSession().setAttribute(ConfigurationManager.getProperty("name.servletcontext.lastpage"), lastUrl);
    }

    private static String getUrlFromRequest(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder(request.getRequestURI());
        String query = request.getQueryString();
        if (query != null) {
            sb.append('?').append(query);
        }
        return sb.toString();
    }

    public static String getLastUrl(HttpServletRequest request) {
        return request.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.lastpage")).toString();
    }
}
