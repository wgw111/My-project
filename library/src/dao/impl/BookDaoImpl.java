package dao.impl;

import domain.Comment;
import domain.PageBean;
import domain.book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
import java.util.Map;
//对book表进行操作
public class BookDaoImpl
{
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public static List<book> findAll(int currentPage,int rows)
    {
        String sql = "select * from `book` limit ?,?";
        int temp = (currentPage-1)*rows;
        List<book> list = template.query(sql,new BeanPropertyRowMapper<book>(book.class),temp,rows);
        return list;
    }

    public static int totalCount()
    {
        String sql = "select count(*) from `book`";
        int count = template.queryForObject(sql,Integer.class);
        return count;
    }

    public static String find(String SBIN)
    {
        String sql = "select `name` from `book` where `SBIN`=?";
        String name = template.queryForObject(sql,String.class,SBIN);
        return name;
    }

    public static void lent(String sbin)
    {
        String sql = "update `book` set `isBrought`='不可借阅' where `SBIN`=?";
        template.update(sql,sbin);
    }

    public static void returnBook(String sbin)
    {
        String sql = "update `book` set `isBrought`='可借阅' where `SBIN`=?";
        template.update(sql,sbin);
    }

    public static void delBook(String sbin)
    {
        String sql = "delete from `book` where `SBIN`=?";
        template.update(sql,sbin);
    }

    public static void addBook(book book)
    {
        String sql = "insert into `book` (`name`,`author`,`SBIN`,`position`) values(?,?,?,?)";
        template.update(sql,book.getName(),book.getAuthor(),book.getSBIN(),book.getPosition());
    }

}
