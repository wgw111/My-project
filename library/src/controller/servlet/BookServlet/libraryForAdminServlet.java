package controller.servlet.BookServlet;

import domain.PageBean;
import domain.book;
import service.ServiceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/libraryForAdminServlet")
public class libraryForAdminServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        PageBean<book> pageBean = new PageBean<book>();
        if(currentPage==null||currentPage.equals(""))
            currentPage = "1";
        if(rows==null||rows.equals(""))
            rows = "5";
        pageBean.setCurrentPage(Integer.parseInt(currentPage));
        pageBean.setRows(Integer.parseInt(rows));
        pageBean = BookServiceImpl.findAll(pageBean);
        req.setAttribute("pb",pageBean);

        String referer = req.getHeader("referer");
        req.getRequestDispatcher("/view/libraryForAdmin.jsp").forward(req,resp);
    }
}
