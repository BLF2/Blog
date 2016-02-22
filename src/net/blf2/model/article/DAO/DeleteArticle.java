package net.blf2.model.article.DAO;

import net.blf2.model.article.info.ArticleInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-1.
 * 文章信息类删除
 */
public class DeleteArticle {
    public Boolean deleteArticleInfo(ArticleInfo articleInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(articleInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
