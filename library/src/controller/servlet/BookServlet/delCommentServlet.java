package controller.servlet.BookServlet;

import service.ServiceImpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delCommentServlet")
public class delCommentServlet extends HttpServlet
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
        HttpSession session = req.getSession();
        if(session.getAttribute("admin")==null)
        {
            req.getRequestDispatcher("view/loginForAdmin.jsp").forward(req,resp);
        }

        String SBIN = req.getParameter("SBIN");
        CommentServiceImpl.delComment(SBIN);
        resp.sendRedirect(req.getContextPath()+"/libraryServlet");
    }
}
