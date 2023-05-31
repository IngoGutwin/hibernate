package de.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.function.Function;

public class PersonHandler {

    private SessionFactory factory;

    public PersonHandler() {
        try {
            this.factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

   /* public Integer addPerson( Person person) {
        Session session = factory.openSession();
        Transaction transaction = null;
        int personID = 0;
        try {
            transaction = session.beginTransaction();
            personID = (Integer) session.save(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }
        return personID;
    }*/

/*
    public Person getPerson( int personID ) {
        Transaction transaction = null;
        try( Session session = factory.openSession();) {
            transaction = session.beginTransaction();
            Person person = session.get( Person.class, personID );
            transaction.commit();
            return person;
        } catch ( HibernateException e ) {
            if( transaction != null ) transaction.rollback();
        }
        return null;
    }
*/
    public Person addPerson (String firstName, String lastName, int age) {
        var person = new Person(firstName,lastName,age);
        addPerson(person);
        return person;
    }
    public void addPerson( Person person ) {
        transaction(session -> {
            session.persist(person);
            return null;
        });
    }

    public Object getPerson(int personID) {
        return transaction( session -> session.get(Person.class, personID) );
    }

    synchronized public Object transaction( Function <Session, Object> function ) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Object object = function.apply(session);
            transaction.commit();
            return object;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
        }
        return null;
    }
}