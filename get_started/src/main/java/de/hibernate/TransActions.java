package de.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Function;

public class TransActions<T> {

    private final SessionFactory factory;

    public TransActions(SessionFactory factory ) {
        this.factory = factory;
    }

    synchronized public T commit( Function< Session, T > function ) {
        Transaction ta = null;
        try( Session session = factory.openSession();) {
            ta = session.beginTransaction();
            T rv =  function.apply(session);
            ta.commit();
            return rv;
        } catch ( HibernateException e ) {
            if( ta != null )ta.rollback();
        }
        return null;
    }

}
