package dao.impl;

import domain.Comment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CommentDaoImpl
{
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void addComment(String id, String sbin, String comment, int score)
    {
        String sql = "insert into `comment` (sbin`,`comments`,`score`) values(?,?,?);";
        template.update(sql,sbin,comment,score);
    }

    public static List<Comment> getComments(String sbin)
    {
        String sql = "select * from `comment` where `SBIN`=?";
        List<Comment> comments = template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class), sbin);
        return comments;
    }

    public static void delComment(String sbin)
    {
        String sql = "delete from `comment` where `SBIN`=?";
        template.update(sql,sbin);
    }
}
