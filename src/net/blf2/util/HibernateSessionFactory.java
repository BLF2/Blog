package net.blf2.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Created by blf2 on 16-1-30.
 */
public class HibernateSessionFactory {
    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";

    /** Holds a single instance of Session */
    private static final ThreadLocal threadLocal = new ThreadLocal();

    /** The single instance of hibernate configuration */
    private static final Configuration cfg = new Configuration();

    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;

    /**
     * Returns the ThreadLocal Session instance. Lazy initialize
     * the SessionFactory if needed.
     *
     * @return Session
     * @throws HibernateException
     */

    public static Session currentSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null) {
            if (sessionFactory == null) {
                try {
                    cfg.configure(CONFIG_FILE_LOCATION);
                    sessionFactory = cfg.buildSessionFactory();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * Close the single hibernate session instance.
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * Default constructor.
     */
    private HibernateSessionFactory() {
    }

}