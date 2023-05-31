package de.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.function.Function;

public class PersonHandler {

    private SessionFactory factory;

    public PersonHandler() {
        try {
            //this.factory = new Configuration().configure().buildSessionFactory();
            this.factory = new Configuration().configure().addAnnotatedClass( Person.class ).buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public int addPerson( String firstName, String lastName, int age  ) {
        return addPerson( new Person( firstName, lastName, age ) );
    }

    public int addPerson( Person person ) {
        var ta = new TransActions<Integer>( this.factory );
        return ta.commit( session -> {
            session.persist( person );
            return person.getId();
        });
    }

    public Person getPerson( int personID ) {
        var ta = new TransActions<Person>( this.factory );

        Function < Session, Person > function = new Function<>() {
            @Override
            public Person apply( Session session ) {
                Person p = session.get( Person.class, personID );
                return p;
            }
        };

        return ta.commit( function );
    }

}