package com.jckk.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp2", loadOnStartup = 1)

public class responseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp2");
//        PrintWriter writer = response.getWriter();
//        response.setHeader("content-type", "text/html;charset=utf-8");
//        writer.write("Hello, response!");
//        writer.write("<h1>Hello, response!</h1>");

        FileInputStream fis = new FileInputStream("/home/xc/Pictures/Screenshots/1.png"); // this is the path to the image
        ServletOutputStream os = response.getOutputStream(); // get the output stream
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while((len = fis.read(buffer)) != -1){ // read the image file
//            os.write(buffer, 0, len);
//        }
        IOUtils.copy(fis, os);
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
