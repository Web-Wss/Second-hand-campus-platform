package shop.massz.servlet.root;

import com.alibaba.fastjson.JSON;
import shop.massz.service.root.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchUserServlet", value = "/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取用户要所有的值
        String value = request.getParameter("value");
        System.out.println(value);
        Object result = UserService.searchUser(value);
        String jsonArray = JSON.toJSONString(result);
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
