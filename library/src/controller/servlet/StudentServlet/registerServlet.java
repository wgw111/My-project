package controller.servlet.StudentServlet;

import domain.Student;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceImpl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        String code_1 = req.getParameter("verifycode");
        String code_2 = (String)session.getAttribute("code");
        if(!code_1.equalsIgnoreCase(code_2))
        {
            req.setAttribute("reg_msg","验证码错误");
            req.getRequestDispatcher("/view/register.jsp").forward(req,resp);
            return;
        }
        Student student = new Student();
        Map<String,String[]> map = req.getParameterMap();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        StudentServiceImpl.register(student);
        resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
    }
}
