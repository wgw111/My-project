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

@WebServlet("/addCommentServlet")
public class addCommentServlet  extends HttpServlet
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
        String SBIN = req.getParameter("SBIN");
        String comment = req.getParameter("comment");
        int score = Integer.parseInt(req.getParameter("score"));

        StudentServiceImpl.addComment(student.getId(),SBIN,comment,score);

        resp.sendRedirect(req.getContextPath()+"/view/StudentInf.jsp");
    }
}

