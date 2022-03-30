package servlet.LoginServlet;

import Bean.LoginData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        获取前端发来的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        将数据存放在LoginData类中
        LoginData loginData = new LoginData(username,password);

        if ("admin".equals(username) && "123456".equals(password)) {
            response.getWriter().print("200");
        }else {
            response.getWriter().print("500");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
