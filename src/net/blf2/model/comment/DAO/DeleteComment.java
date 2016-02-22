package net.blf2.model.comment.DAO;

import net.blf2.model.comment.info.CmtInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-11.
 * 评论删除
 */
public class DeleteComment {
    public Boolean deleteCmtInfo(CmtInfo cmtInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cmtInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
