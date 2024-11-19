package ru.rsreu.golyashhuk.filters;


import ru.rsreu.golyashhuk.command.ActionCommand;
import ru.rsreu.golyashhuk.command.ActionFactory;
import ru.rsreu.golyashhuk.config.ConfigurationManager;
import ru.rsreu.golyashhuk.datalayer.entities.User;
import ru.rsreu.golyashhuk.role.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        if (session == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Role role = (Role) session.getAttribute(ConfigurationManager.getProperty("name.servletcontext.role"));
        User user = (User) session.getAttribute(ConfigurationManager.getProperty("name.servletcontext.user"));

        if (user == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        ActionCommand command = ActionFactory.defineCommand(req);

        if (role.haveCommand(command)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            res.sendRedirect(ConfigurationManager.getProperty("path.page.error.accessdenied"));
        }

    }


}
