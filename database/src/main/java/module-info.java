module de.domain.hibernate.database {
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens de.hibernate.database to org.hibernate.orm.core;
    exports de.hibernate.database;
}