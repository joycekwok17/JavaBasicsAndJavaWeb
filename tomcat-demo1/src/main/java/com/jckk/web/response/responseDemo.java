package com.jckk.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp1", loadOnStartup = 1)

public class responseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1");
//        response.setStatus(302);
//        response.setHeader("location", "/tomcat-demo1/resp2");

        // response.sendRedirect() can be used to redirect to external websites
        response.sendRedirect(request.getContextPath() + "/resp2");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
