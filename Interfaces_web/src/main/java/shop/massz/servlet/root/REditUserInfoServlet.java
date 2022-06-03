package shop.massz.servlet.root;


import shop.massz.domain.UserBean;
import shop.massz.service.root.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "REditUserInfoServlet", value = "/REditUserInfoServlet")
public class REditUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取用户id，用户名，昵称，密码
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String user_username = request.getParameter("user_username");
        String user_nickname = request.getParameter("user_nickname");
        String user_password = request.getParameter("user_password");
//        System.out.println(user_id);
//        System.out.println(user_username);
//        System.out.println(user_nickname);
//        System.out.println(user_password);
        UserBean userBean = new UserBean();
        userBean.setUser_id(user_id);
        userBean.setUser_username(user_username);
        userBean.setUser_nickname(user_nickname);
        userBean.setUser_password(user_password);
        boolean result = UserService.editUserInfo(userBean);
        System.out.println(result);
        response.getWriter().print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
