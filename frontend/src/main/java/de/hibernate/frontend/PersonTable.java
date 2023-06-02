package de.hibernate.frontend;

import de.hibernate.database.Person;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonTable extends TableView <Person> {


    public PersonTable() {
        TableColumn < Person, Integer   > id        = new TableColumn<>("ID");
        TableColumn < Person, String    > firstName = new TableColumn<>("FIRSTNAME");
        TableColumn < Person, String    > lastName  = new TableColumn<>("LASTNAME");
        TableColumn < Person, Integer   > age       = new TableColumn<>("AGE");

        id          .setCellValueFactory( new PropertyValueFactory<>("id") );
        firstName   .setCellValueFactory( new PropertyValueFactory<>("firstName") );
        lastName    .setCellValueFactory( new PropertyValueFactory<>("lastName") );
        age         .setCellValueFactory( new PropertyValueFactory<>("age") );

        this.getColumns().add(id);
        this.getColumns().add(firstName);
        this.getColumns().add(lastName);
        this.getColumns().add(age);
    }

}
