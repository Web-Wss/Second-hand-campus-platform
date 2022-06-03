package shop.massz.servlet;



import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CheckCodeServlet", value = "/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    private static final int WIDTH = 200;//设置验证码图片宽度
    private static final int HEIGHT = 60;//设置验证码图片高度
    private static final int LENGTH = 4;//设置验证码长度
    public static final int LINECOUNT = 40;//干扰线的数目

    //验证码的字符库
    private static final String str = "023456789" +
            "ABCDEFGHJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz";

    //通过随机数取字符库中的字符组合成4位验证码
    private static Random random = new Random();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");//Origin, X-Requested-With, Content-Type, Accept,Access-Token

//设置数据类型为图片
        response.setContentType("image/jpeg");
        //设置不进行缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");


        //获取画笔
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = image.getGraphics();

        //设置背景颜色并绘制矩形背景
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //验证码的绘制
        String code = drawChar(g);
        System.out.println("验证码:" + code);

        //随机线的绘制
        for (int i = 0; i < LINECOUNT; i++) {
            drawLine(g);
        }
        String codeyzm1 = request.getParameter("uuidyzm1");
        System.out.println("codeyzm1"+codeyzm1);
        //在session中存入当前的code码，便于验证
        this.getServletContext().setAttribute(codeyzm1,code);
        //绘制图片
        g.dispose();
        //将图片输出到response中
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    //获取不同颜色
    public Color getColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    //获取字体样式
    public Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 50);
    }

    //绘制字符
    public String drawChar(Graphics g) {
        String code = "";
        g.setFont(getFont());
        for (int i = 0; i < LENGTH; i++) {
            char c = str.charAt(random.nextInt(str.length()));
            g.setColor(getColor());
            g.drawString(c + "", 50 * i + 12, 50);
            code = code + c;
        }
        return code;
    }

    //绘制随机线
    public void drawLine(Graphics g) {
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(HEIGHT);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.setColor(getColor());
        g.drawLine(x, y, x + xl, y + yl);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin, X-Requested-With, Content-Type, Accept,Access-Token");//Origin, X-Requested-With, Content-Type, Accept,Access-Token

        String uuidyzm2 = request.getParameter("uuidyzm2");
        System.out.println("uuidyzm2"+uuidyzm2);
        System.out.println("session中获取验证码的值：" + this.getServletContext().getAttribute(uuidyzm2));
        String code1 = (String) this.getServletContext().getAttribute(uuidyzm2);
        String webCode = request.getParameter("code");
        System.out.println("前端发送来的验证码:"+webCode);
        if (code1.equals(webCode)) {
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }
    }
}
