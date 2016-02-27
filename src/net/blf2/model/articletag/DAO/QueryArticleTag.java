package net.blf2.model.articletag.DAO;

import net.blf2.model.articletag.info.ArticleTag;
import net.blf2.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by blf2 on 16-2-21.
 * 查询文章标签
 */
public class QueryArticleTag {
    public ArticleTag queryArticleTagById(Integer acId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleTag at where at.acId="+acId);
        if(query.list().size() == 0)
            return null;
        ArticleTag articleTag = (ArticleTag)query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return articleTag;
    }
    public ArticleTag queryArticleTagByDoubleId(Integer articleId,Integer tagId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleTag at where at.articleId="+articleId+" and at.tagId="+tagId);
        if(query.list().size() == 0)
            return null;
        ArticleTag articleTag = (ArticleTag)query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return articleTag;
    }
    public List<ArticleTag> queryArticleTagByArticleId(Integer articleId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleTag at where at.articleId="+articleId);
        if(query.list().size() == 0)
            return null;
        List<ArticleTag> list = query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
    public List<ArticleTag> queryArticleTagByTagId(Integer tagId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleTag at where at.tagId="+tagId);
        if(query.list().size() == 0)
            return null;
        List<ArticleTag> list = query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
