package shop.massz.servlet;


import shop.massz.domain.UserBean;
import shop.massz.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_username = request.getParameter("user_username");
        String user_password = request.getParameter("user_password");
        String user_nickname = request.getParameter("user_nickname");
        String user_phone = request.getParameter("user_phone");
        String user_qq = request.getParameter("user_qq");
//        System.out.println(user_username);
//        System.out.println(user_password);
//        System.out.println(user_nickname);
//        System.out.println(user_phone);
//        System.out.println(user_qq);
        UserBean userBean = new UserBean();
        userBean.setUser_username(user_username);
        userBean.setUser_password(user_password);
        userBean.setUser_nickname(user_nickname);
        userBean.setUser_phone(user_phone);
        userBean.setUser_qq(user_qq);
        boolean result = RegisterService.register(userBean);
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
