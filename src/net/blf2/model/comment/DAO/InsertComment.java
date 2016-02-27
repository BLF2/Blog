package net.blf2.model.comment.DAO;

import net.blf2.model.comment.info.CmtInfo;
import net.blf2.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-11.
 * 评论数据库插入
 */
public class InsertComment {
    public CmtInfo insertCmtInfo(CmtInfo cmtInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(cmtInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return cmtInfo;
    }
}
