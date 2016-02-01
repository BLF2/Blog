package net.blf2.model.user.DAO;

import net.blf2.model.article.info.ArticleInfo;
import net.blf2.model.user.info.LoginInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by blf2 on 16-1-30.
 * 登录信息删除
 */
public class DbDelete {
    public Boolean deleteLoginInfo(LoginInfo loginInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        //先删除这个人的所有文章
        Query query = session.createQuery("from ArticleInfo ai where ai.writerId=" + loginInfo.getLoginId());
        Integer length = query.list().size();
        if(length > 0){
            List<ArticleInfo> list = query.list();
            for(ArticleInfo ai : list){
                session.delete(ai);
            }
        }
        //删除这个人的信息
        session.delete(loginInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
