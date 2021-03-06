package net.blf2.model.article.DAO;

import net.blf2.model.article.info.ArticleInfo;
import net.blf2.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-1.
 * 文章信息类的插入
 *
 */
public class InsertArticle {
    public ArticleInfo insertArticleInfo(ArticleInfo articleInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(articleInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return articleInfo;
    }
}
