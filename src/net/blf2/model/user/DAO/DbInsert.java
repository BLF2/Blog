package net.blf2.model.user.DAO;

import net.blf2.model.user.info.LoginInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-1-30.
 * 登录信息的插入
 */
public class DbInsert {
    public LoginInfo insertLoginInfo(LoginInfo loginInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(loginInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return loginInfo;
    }
}
