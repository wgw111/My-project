package service.ServiceImpl;

import dao.impl.BookDaoImpl;
import dao.impl.CommentDaoImpl;
import domain.Comment;

import java.util.List;

public class CommentServiceImpl
{
    public static List<Comment> getComments(String SBIN)
    {
        List<Comment> comments = CommentDaoImpl.getComments(SBIN);
        return comments;
    }

    public static void delComment(String sbin)
    {
        CommentDaoImpl.delComment(sbin);
    }
}
