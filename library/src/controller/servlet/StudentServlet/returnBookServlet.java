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

@WebServlet("/returnBookServlet")
public class returnBookServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        HttpSession httpSession = req.getSession();
        String SBIN = req.getParameter("SBIN");
        System.out.println(111);
        StudentServiceImpl.returnBook(SBIN);
        if(httpSession.getAttribute("student")!=null)
            req.getRequestDispatcher("/view/addComment.jsp").forward(req,resp);
        else
        {
            resp.sendRedirect(req.getContextPath()+"/libraryForAdminServlet");
        }
    }
}
