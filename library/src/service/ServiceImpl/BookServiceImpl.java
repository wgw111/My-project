package service.ServiceImpl;

import dao.impl.BookDaoImpl;
import domain.Comment;
import domain.PageBean;
import domain.book;

import java.util.List;

public class BookServiceImpl
{

    public static PageBean<book> findAll(PageBean<book> pageBean)
    {
        int totalCount = BookDaoImpl.totalCount();
        int currentPage = pageBean.getCurrentPage();
        int rows = pageBean.getRows();
        if(totalCount%rows==0)
        {
            pageBean.setTotalPage(totalCount/rows);
        }
        else
        {
            pageBean.setTotalPage(totalCount/rows+1);
        }
        List<book> books = BookDaoImpl.findAll(currentPage,rows);
        pageBean.setList(books);
        pageBean.setTotalCount(totalCount);
        return pageBean;
    }

    public static void delBook(String sbin)
    {
        BookDaoImpl.delBook(sbin);
    }

    public static void addBook(book book)
    {
        BookDaoImpl.addBook(book);
    }

}
