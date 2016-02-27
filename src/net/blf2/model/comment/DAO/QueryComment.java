package net.blf2.model.comment.DAO;

import net.blf2.model.comment.info.CmtInfo;
import net.blf2.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by blf2 on 16-2-11.
 * 评论查询
 */
public class QueryComment {
    public CmtInfo queryCmtInfoById(Integer id){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CmtInfo ci where ci.cmtId="+id);
        if(query.list().size() == 0)
            return null;
        CmtInfo cmtInfo = (CmtInfo) query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return cmtInfo;
    }
    public List<CmtInfo> queryCmtInfoByAticleId(Integer aId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from CmtInfo ci where ci.articleId="+aId);
        if(query.list().size() == 0)
            return null;
        List<CmtInfo>list = query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
