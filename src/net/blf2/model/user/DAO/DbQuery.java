package net.blf2.model.user.DAO;

import net.blf2.model.user.info.LoginInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by blf2 on 16-1-30.
 * 登录信息查询
 */
public class DbQuery {
    public LoginInfo queryLoginInfoById(Integer id){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from LoginInfo loginInfo where loginInfo.loginId="+id);
        if(query.list().size() == 0)
            return null;
        LoginInfo loginInfo = (LoginInfo)query.list().get(0);
        return loginInfo;
    }
    public LoginInfo queryLoginInfoByEmail(String email){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from LoginInfo loginInfo where loginInfo.loginEmail='"+email+"'");
        if(query.list().size() == 0)
            return null;
        LoginInfo loginInfo = (LoginInfo)query.list().get(0);
        return loginInfo;
    }
    public List<LoginInfo> queryLoginInfoAll(){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from LoginInfo loginInfo");
        if(query.list().size() == 0)
            return null;
        List<LoginInfo>list = query.list();
        return list;
    }
}
