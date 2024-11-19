package ru.rsreu.golyashhuk.filters;

import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.ActionFactory;
import ru.rsreu.golyashhuk.command.CommandEnum;
import ru.rsreu.golyashhuk.command.CommandUtils;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.UserDataDAO;
import ru.rsreu.golyashhuk.datalayer.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BlockFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        ActionCommand command = ActionFactory.defineCommand(req);

        if (command == CommandEnum.LOGIN.getCurrentCommand() || command == CommandEnum.LOGOUT.getCurrentCommand()) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        UserDataDAO userDataDAO = CommandUtils.getUserDataDAO(req);
        User user = (User) req.getSession().getAttribute(ConfigurationManager.getProperty("name.servletcontext.user"));
        if (userDataDAO.isBlockedUser(user.getId())) {
            res.sendRedirect(ConfigurationManager.getProperty("path.page.error.blocked"));
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
