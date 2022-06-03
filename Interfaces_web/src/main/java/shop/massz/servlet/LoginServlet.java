package shop.massz.servlet;



import com.alibaba.fastjson.JSON;
import shop.massz.domain.UserBean;
import shop.massz.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_username = request.getParameter("username");
        String user_password = request.getParameter("password");

        UserBean result = LoginService.Login(user_username, user_password);
        System.out.println("数据库中查询到的数据："+ result);

        if (result.getUser_username() != null) {
//        生成token
            String token = String.valueOf(UUID.randomUUID());
//        将token存在ServletContext中
            System.out.println("生成的token值：" + token);
            this.getServletContext().setAttribute(token,user_username);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("result",result);
            String jsonArray = JSON.toJSONString(map);
            System.out.println("jsonArray===="+jsonArray);
            response.getWriter().print(jsonArray);
        }else {
            response.getWriter().print("登录失败");
        }
    }
}
