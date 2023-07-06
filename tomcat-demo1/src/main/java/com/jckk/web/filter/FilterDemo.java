package com.jckk.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest) request;
        HttpSession session = hsr.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("login_msg", "Please login first");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }
}
