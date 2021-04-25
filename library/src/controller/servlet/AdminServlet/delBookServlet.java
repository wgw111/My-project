package controller.servlet.AdminServlet;

import service.ServiceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delBookServlet")
public class delBookServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String isBrought = req.getParameter("isBrought");
        if(isBrought.equals("不可借阅"));
        {
            req.setAttribute("del_msg","该书已被借阅");
            req.getRequestDispatcher("/libraryForAdminServlet").forward(req,resp);
        }

        req.removeAttribute("del_msg");
        String SBIN = req.getParameter("SBIN");
        BookServiceImpl.delBook(SBIN);
        resp.sendRedirect(req.getContextPath()+"/libraryForAdminServlet");
    }
}
