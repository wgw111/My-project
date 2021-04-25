package controller.servlet.AdminServlet;

import domain.Admin;
import domain.PageBean;
import domain.Student;
import domain.book;
import service.ServiceImpl.BookServiceImpl;
import service.ServiceImpl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllStudentServlet")
public class findAllStudentServlet extends HttpServlet
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
        PageBean<Student> pageBean = new PageBean<Student>();
        if(currentPage==null||currentPage.equals(""))
            currentPage = "1";
        if(rows==null||rows.equals(""))
            rows = "5";
        pageBean.setCurrentPage(Integer.parseInt(currentPage));
        pageBean.setRows(Integer.parseInt(rows));
        pageBean = StudentServiceImpl.findAll(pageBean);
        req.setAttribute("pb",pageBean);

        req.getRequestDispatcher("/view/StudentInfForAdmin.jsp").forward(req,resp);
    }
}
