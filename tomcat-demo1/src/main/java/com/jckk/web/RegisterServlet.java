package com.jckk.web;

import com.jckk.mapper.UserMapper;
import com.jckk.pojo.User;
import com.jckk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory(); // 获取 SqlSessionFactory 对象 (单例模式)  (SqlSessionFactoryUtils.java)

        SqlSession sqlSession = sqlSessionFactory.openSession();  // 获取 SqlSession 对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUsername(username);

        if (user == null) {
            mapper.add(user1);
            sqlSession.commit(); // 提交事务 (必须手动提交) (不然数据库中不会有数据)
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Register successfully!");
            sqlSession.close();
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Username already exists!");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
