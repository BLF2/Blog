package net.blf2.model.article.DAO;

import net.blf2.model.article.info.ArticleInfo;
import net.blf2.model.article.staticfile.IArticleInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by blf2 on 16-2-1.
 * 文章信息的查询
 */
public class DbQuery {
    public ArticleInfo queryArticleInfoById(Integer id){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleInfo articleInfo where articleInfo.articleId="+id);
        if(query.list().size() == 0)
            return null;
        ArticleInfo articleInfo = (ArticleInfo) query.list().get(0);
        return articleInfo;
    }
    public List<ArticleInfo> queryArticleInfoByWriterId(Integer writerId){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleInfo articleInfo where articleInfo.writerId="+writerId);
        if(query.list().size() == 0)
            return null;
        List<ArticleInfo>list = query.list();
        return list;
    }
    public List<ArticleInfo> queryArticleInfoAll(){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from ArticleInfo articleInfo");
        if(query.list().size() == 0)
            return null;
        List<ArticleInfo>list = query.list();
        return list;
    }
}
