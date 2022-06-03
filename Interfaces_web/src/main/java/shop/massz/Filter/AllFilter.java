package shop.massz.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "AllFilter", value = {"/QueryLoveGoodsServlet","/PersonGoodsServlet","/LoveGoodsServlet","/EditUserInfoServlet","/DeletePersonGoodsServlet","/DeleteLoveGoodsServlet","/AddLoveGoodsServlet"})
public class AllFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
//        System.out.println("Filter被创建了");
    }
    public void destroy() {
//        System.out.println("Filter 被销毁了...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request1 = (HttpServletRequest) request;

        response.setContentType("text/html;charset=utf-8");
        // 在拦截之前的执行
//        System.out.println("拦截之前");
        if (request1.getHeader("token") != null) {
//            获取前端发来的token
            String token1 = request1.getHeader("token");
            System.out.println("前端发来的token" + token1);
//            获取前端发来的user_username
            String user_username = request1.getHeader("user_username");
            System.out.println(user_username);

//            通过传来的token获取user_username
            ServletContext context = request1.getServletContext();
            String user_username1 = (String) context.getAttribute(token1);
            System.out.println(user_username1);
//            判断token与user_username是否匹配
            if (user_username.equals(user_username1) && token1 != null) {
                System.out.println("验证成功");
                chain.doFilter(request, response);  // 放行urlPatterns 对应的地址
            }else {
                System.out.println("验证失败");
                response.getWriter().print("false");
            }
        }else {
            System.out.println("验证失败");
            response.getWriter().print("false");
        }

//        System.out.println("服务器中获取的token对应的user_username"+token2);
        // 拦截
//        chain.doFilter(request, response);  // 放行urlPatterns 对应的地址
        // 拦截之后
//        System.out.println("拦截之后");
    }
}
