package dao.impl;

import com.alibaba.druid.support.json.JSONUtils;
import domain.book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;
//对booklent表进行操作
public class BookLentDaoImpl
{
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static List<book> FindBookList(String id)
    {
        String sql = "select * from `booklent` where `id`= ?";
        List<book> list = template.query(sql,new BeanPropertyRowMapper<book>(book.class),id);
        return list;
    }

    public static void lent(String id, String sbin, String name)
    {
        String sql = "insert into `booklent` (`id`,`sbin`,`name`) values(?,?,?)";
        template.update(sql,id,sbin,name);
    }

    public static void returnBook(String sbin)
    {
        String sql = "delete from `booklent` where`SBIN`=?";
        template.update(sql,sbin);
    }

}
