package net.blf2.model.user.DAO;

import net.blf2.model.user.info.LoginInfo;
import net.blf2.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-1-30.
 * 登录信息删除
 */
public class DeleteUser {
    public Boolean deleteLoginInfo(LoginInfo loginInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(loginInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
