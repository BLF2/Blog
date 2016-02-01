package net.blf2.model.tag.DAO;

import net.blf2.model.tag.info.TagInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by blf2 on 16-2-1.
 * 标签类的更新
 */
public class DbUpdate {
    public Boolean updateTagInfo(TagInfo tagInfo){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        session.update(tagInfo);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return true;
    }
}
