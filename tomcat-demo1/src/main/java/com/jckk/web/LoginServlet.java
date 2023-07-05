package com.jckk.web;

import com.jckk.mapper.UserMapper;
import com.jckk.pojo.User;
import com.jckk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + " " + password);


        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username, password);

        sqlSession.close();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if (user != null) {
//            request.setAttribute("user", user);
//            request.getRequestDispatcher("/success.jsp").forward(request, response);
            writer.println("Login Success!");
        } else {
            //            request.getRequestDispatcher("/fail.jsp").forward(request, response);
            writer.println("Login Fail!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
