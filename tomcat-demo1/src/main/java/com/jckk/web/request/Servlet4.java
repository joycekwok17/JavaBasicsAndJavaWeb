package com.jckk.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 7/3/23
 */
@WebServlet(urlPatterns = "/req1100", loadOnStartup = 1)
public class Servlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String method = req.getMethod();
//        System.out.println("method: " + method);
//        System.out.println(req.getContextPath() + " \n " + req.getRequestURL() + "\n " + req.getRequestURI() + "\n " + req.getQueryString());
//        System.out.println("doGet...");
//        String header = req.getHeader("User-Agent");
//        System.out.println(header);
        Map<String, String[]> parameterMap = req.getParameterMap();
        for(String key: parameterMap.keySet()){
            String[] values = parameterMap.get(key);
            System.out.println(key + " = " + String.join(",", values));
        }
        System.out.println("--------------------");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doPost...");
//        BufferedReader br = req.getReader();
//        String line = br.readLine();
//        System.out.println(line);
        this.doGet(req, resp);
    }
}
