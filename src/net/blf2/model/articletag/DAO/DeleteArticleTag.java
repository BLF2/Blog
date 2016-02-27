package net.blf2.model.articletag.DAO;

import net.blf2.model.articletag.info.ArticleTag;
import net.blf2.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-21.
 */
public class DeleteArticleTag {
    public Boolean deleteArticleTag(ArticleTag articleTag){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(articleTag);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
