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
        session.delete(loginInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
