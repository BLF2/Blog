package net.blf2.model.articletag.DAO;

import net.blf2.model.articletag.info.ArticleTag;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-21.
 * 给文章添加标签
 */
public class InsertArticleTag {
    public ArticleTag insertArticleTag(ArticleTag articleTag){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(articleTag);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return articleTag;
    }
}
