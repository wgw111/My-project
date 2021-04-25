package controller.servlet.BookServlet;

import domain.Comment;
import service.ServiceImpl.BookServiceImpl;
import service.ServiceImpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");

        HttpSession httpSession = req.getSession();
        String SBIN = req.getParameter("SBIN");
        List<Comment> comments = CommentServiceImpl.getComments(SBIN);
        httpSession.setAttribute("comments",comments);
        httpSession.setAttribute("name",req.getParameter("name"));

        resp.sendRedirect(req.getContextPath()+"/view/comment.jsp");
    }
}
