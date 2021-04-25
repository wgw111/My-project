package controller.servlet.StudentServlet;

import domain.Student;
import service.ServiceImpl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/lendBookServlet")
public class lendBookServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");
        System.out.println(4444444);
        if(student==null)
        {
            req.getRequestDispatcher("view/login.jsp").forward(req,resp);
            System.out.println(3333);
            return;
        }
        if(req.getParameter("isBrought").equals("不可借阅"))
        {
            session.setAttribute("lend_msg","该书不可借阅");
            req.getRequestDispatcher("/libraryServlet").forward(req,resp);
            System.out.println(2222);
            return;
        }
        if(student.getBlacklist()==1)
        {
            session.setAttribute("lend_msg","您有书逾期未还");
            req.getRequestDispatcher("/libraryServlet").forward(req,resp);
            return;
        }
        System.out.println(1111);
        String SBIN = req.getParameter("SBIN");
        StudentServiceImpl.lend(student.getId(),SBIN);
        resp.sendRedirect(req.getContextPath()+"/libraryServlet");
    }
}
