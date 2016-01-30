package net.blf2.model.user.DAO;

import net.blf2.model.user.info.LoginInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-1-30.
 */
public class DbUpdate {
    public Boolean updateLoginInfo(LoginInfo loginInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.update(loginInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
