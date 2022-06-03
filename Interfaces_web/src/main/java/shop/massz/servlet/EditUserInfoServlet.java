package shop.massz.servlet;


import shop.massz.domain.UserBean;
import shop.massz.service.EditUserInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserInfoServlet", value = "/EditUserInfoServlet")
public class EditUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id1 = request.getParameter("user_id");
        int user_id = Integer.parseInt(user_id1);
        String user_username = request.getParameter("user_username");
//        String user_password = request.getParameter("user_password");
        String user_nickname = request.getParameter("user_nickname");
        String user_qq = request.getParameter("user_qq");
        String user_wx = request.getParameter("user_wx");
        String user_phone = request.getParameter("user_phone");
        String user_address = request.getParameter("user_address");
        UserBean userBean = new UserBean();
        userBean.setUser_id(user_id);
        userBean.setUser_username(user_username);
//        userBean.setUser_password(user_password);
        userBean.setUser_nickname(user_nickname);
        userBean.setUser_qq(user_qq);
        userBean.setUser_wx(user_wx);
        userBean.setUser_phone(user_phone);
        userBean.setUser_address(user_address);
//        修改用户信息(根据user_id)
        boolean result = EditUserInfoService.edituserInfo(userBean);
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
