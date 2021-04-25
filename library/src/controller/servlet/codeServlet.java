package controller.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/codeServlet")
public class codeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int width = 200, height = 100;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0,0,width-1,height-1);
        graphics.setColor(Color.pink);
        StringBuilder s = new StringBuilder();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random ran = new Random();//随即类
        int index = ran.nextInt(str.length());//生成随机下标
        for(int i=0;i<4;i++)
        {
            index = ran.nextInt(str.length());
            s.append(str.charAt(index));
            graphics.drawString(str.charAt(index)+"",width/5*i,height/2);
        }
        graphics.setColor(Color.green);
        for(int i=0;i<10;i++)
        {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            graphics.drawLine(x1,x2,y1,y2);
        }
        ImageIO.write(image,"jpg",resp.getOutputStream());
        HttpSession httpSession = req.getSession();
        String val = s.toString();
        httpSession.setAttribute("code",val);
    }
}
