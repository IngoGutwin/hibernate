module de.domain.hibernate.database {
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    exports de.hibernate.database;
}