package service.ServiceImpl;

import dao.impl.AdminDaoImpl;
import domain.Admin;

public class AdminServiceImpl
{
    public static Admin find(Admin admin)
    {
        admin = AdminDaoImpl.find(admin.getUsername(),admin.getPassword());
        return admin;
    }
}
