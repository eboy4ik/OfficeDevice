package ru.rsreu.golyashhuk;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.ActionFactory;
import ru.rsreu.golyashhuk.command.CommandUtils;

/**
 * The FrontController class is a servlet that is the main point
 * for processing HTTP requests in the application.
 * It receives a command from the request and goes to the corresponding page
 */
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles the HTTP GET request.
     * This method receives a command from the request
     * and goes to the corresponding page and saves the last page.
     *
     * @param request  the HttpServletRequest object that contains the request data
     * @param response the HttpServletResponse object that will contain the response data
     * @throws ServletException if an error occurs during request processing
     * @throws IOException if an input or output error occurs during the operation
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = getPageFromRequest(request);
        CommandUtils.updateLastURL(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP POST request.
     * This method determines the page to redirect to
     * based on the request parameters. If the page is null,
     * it redirects to the last accessed URL.
     *
     * @param request  the HttpServletRequest object that contains the request data
     * @param response the HttpServletResponse object that will contain the response data
     * @throws IOException if an input or output error occurs during the operation
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String page = getPageFromRequest(request);
        if (page == null) {
            goToLastPage(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + page);
    }

    /**
     * Retrieves the page from the request.
     *
     * @param request the HttpServletRequest object that contains the request data
     * @return the path to the page to be displayed, as determined by the command
     */
    private String getPageFromRequest(HttpServletRequest request) {
        ActionCommand command = ActionFactory.defineCommand(request);
        return command.execute(request);
    }

    /**
     * Redirects the response to the last accessed page.
     *
     * @param request  the HttpServletRequest object that contains the request data
     * @param response the HttpServletResponse object that will contain the response data
     * @throws IOException if an input or output error occurs during the operation
     */
    private void goToLastPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + CommandUtils.getLastUrl(request));
    }
}
