package dao.impl;

import domain.PageBean;
import domain.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

//对student进行操作
public class StudentDaoImpl
{
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static void register(Student student)
    {
        String sql = "Insert into `student` (`id`,`name`,`username`,`password`,`gender`) values(?,?,?,?,?)";
        template.update(sql,student.getId(),student.getName(),student.getUsername(),student.getPassword(),student.getGender());
    }


    public static Student find(Student student)
    {
        String sql = "select * from `student` where `username`=? and `password` = ?";
        try
        {
            Student student1 = template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),student.getUsername(),student.getPassword());
            return student1;
        }catch (Exception e)
        {
            return null;
        }
    }



    public static int findCount()
    {
        String sql = "select count(*) from `student`";
        int count = template.queryForObject(sql,Integer.class);
        return count;
    }

    public static List<Student> findAll(int currentPage, int rows)
    {
        int temp = (currentPage-1)*rows;
        String sql = "select * from `student` limit ?,?";
        List<Student> students = template.query(sql,new BeanPropertyRowMapper<Student>(Student.class),temp,rows);
        return students;
    }

    public static void addBlackList(String id)
    {
        String sql = "update `student` set `blacklist`=1 where `id`=? ";
        template.update(sql,id);
    }


}
