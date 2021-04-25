package service.ServiceImpl;

import com.alibaba.druid.support.json.JSONUtils;
import dao.impl.BookDaoImpl;
import dao.impl.BookLentDaoImpl;
import dao.impl.CommentDaoImpl;
import dao.impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;
import domain.book;


import java.util.List;
//对学生行为进行操作
public class StudentServiceImpl
{
    public static void register(Student student)
    {
        StudentDaoImpl.register(student);
    }

    public static Student find(Student student)
    {
        try {
            Student student1 = StudentDaoImpl.find(student);
            List<book> books = BookLentDaoImpl.FindBookList(student1.getId());
            student1.setBookList(books);  //寻找学生借阅的书
            return student1;
        }
        catch (NullPointerException e)
        {
            return null;
        }
    }

    public static void lend(String id, String SBIN)
    {
        String name = BookDaoImpl.find(SBIN);
        BookLentDaoImpl.lent(id,SBIN,name);
        BookDaoImpl.lent(SBIN);
    }

    public static void returnBook(String sbin)
    {
        BookLentDaoImpl.returnBook(sbin);
        BookDaoImpl.returnBook(sbin);
    }

    public static void addComment(String id, String sbin, String comment, int score)
    {
        CommentDaoImpl.addComment(id,sbin,comment,score);
    }

    public static PageBean<Student> findAll(PageBean<Student> pageBean)
    {
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        int totalPage = 0;
        int totalCount = StudentDaoImpl.findCount();
        pageBean.setTotalCount(totalCount);

        if(totalCount%rows==0)
        {
            totalPage = totalCount/rows;
        }
        else
        {
            totalPage = totalCount/rows+1;
        }
        pageBean.setTotalPage(totalPage);

        List<Student> students = StudentDaoImpl.findAll(pageBean.getCurrentPage(),pageBean.getRows());
        pageBean.setList(students);
        return pageBean;
    }

    public static void addBlackList(String id)
    {
        StudentDaoImpl.addBlackList(id);
    }
}
