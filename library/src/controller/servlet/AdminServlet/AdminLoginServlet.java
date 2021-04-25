package controller.servlet.AdminServlet;

import domain.Admin;
import domain.Student;
import org.apache.commons.beanutils.BeanUtils;
import service.ServiceImpl.AdminServiceImpl;
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

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("student");
        req.setCharacterEncoding("utf-8");
        String code_1 = req.getParameter("verifycode");
        String code_2 = (String) httpSession.getAttribute("code");
        if(!code_1.equalsIgnoreCase(code_2))
        {
            req.setAttribute("login_msg","验证码错误");
            req.getRequestDispatcher("/view/loginForAdmin.jsp").forward(req,resp);
            return;
        }

        Map<String,String[]> map = req.getParameterMap();
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        admin = AdminServiceImpl.find(admin);
        if(admin==null)
        {
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/view/loginForAdmin.jsp").forward(req,resp);
            return;
        }
        httpSession.setAttribute("admin",admin);
        resp.sendRedirect(req.getContextPath()+"/libraryForAdminServlet");
    }
}
