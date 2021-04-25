package dao.impl;

import domain.Admin;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class AdminDaoImpl
{
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public static Admin find(String username, String password)
    {
        String sql = "select * from `admin` where `username`=? and `password`=?";
        Admin admin = null;
        admin = template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),username,password);
        return admin;
    }

}
