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

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("admin");
        req.setCharacterEncoding("utf-8");
        Map<String,String[]> map = req.getParameterMap();
        String code_1 = req.getParameter("verifycode");
        String code_2 = (String) httpSession.getAttribute("code");
        if(!code_1.equalsIgnoreCase(code_2))
        {
            req.setAttribute("login_msg","验证码错误");
            req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
            return;
        }

        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        student = StudentServiceImpl.find(student);
        if(student==null)
        {
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/view/login.jsp").forward(req,resp);
            return;
        }
        httpSession.setAttribute("student",student);
        String referer = req.getHeader("referer");
        if(referer!=null&&referer.contains("%E5%8F%AF%E5%80%9F%E9%98%85"))//%E5%8F%AF%E5%80%9F%E9%98%85是可借阅的url编码
        {
            req.getRequestDispatcher("/lendBookServlet").forward(req,resp);
            return;
        }
        else
        {
            resp.sendRedirect(req.getContextPath()+"/view/StudentInf.jsp");
        }
    }
}
