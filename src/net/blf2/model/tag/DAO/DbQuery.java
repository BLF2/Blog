package net.blf2.model.tag.DAO;

import net.blf2.model.tag.info.TagInfo;
import net.blf2.staticclass.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by blf2 on 16-2-1.
 * 标签类的查询
 */
public class DbQuery {
    public TagInfo queryTagInfoById(Integer id){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from TagInfo ti where ti.tagId="+id);
        if(query.list().size() == 0)
            return null;
        TagInfo tagInfo = (TagInfo) query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return tagInfo;
    }
    public TagInfo queryTagInfoByName(String name){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from TagInfo ti where ti.tagName='"+name+"'");
        if(query.list().size() == 0)
            return null;
        TagInfo tagInfo = (TagInfo) query.list().get(0);
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return tagInfo;
    }
    public List<TagInfo> queryTagInfoAll(){
        Session session = HibernateSessionFactory.currentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from TagInfo");
        if(query.list().size() == 0)
            return null;
        List<TagInfo>list = query.list();
        transaction.commit();
        HibernateSessionFactory.closeSession();
        return list;
    }
}
