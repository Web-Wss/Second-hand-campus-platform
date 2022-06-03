package shop.massz.servlet.root;


import shop.massz.service.root.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserStatusServlet", value = "/EditUserStatusServlet")
public class EditUserStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取用户id
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        System.out.println("user_id=== "+user_id);
//        获取用户要要修改的状态
        String user_status = request.getParameter("user_status");
        int status = 0;
        if (user_status.equals("true")) {
            status = 1;
        }else {
            status = 0;
        }
        System.out.println("user_status=== " + user_status);
        System.out.println("status=== " + status);

        boolean result = UserService.editUserStatus(user_id, status);
        System.out.println(result);
        response.getWriter().print(result);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
