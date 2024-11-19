package ru.rsreu.golyashhuk.filters;


import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.ActionFactory;
import ru.rsreu.golyashhuk.command.CommandEnum;
import ru.rsreu.golyashhuk.config.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizedFilter implements Filter {

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

        if (session == null || session.getAttribute(ConfigurationManager.getProperty("name.servletcontext.user")) == null) {
            res.sendRedirect(ConfigurationManager.getProperty("path.page.error.sessionended"));
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
