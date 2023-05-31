package de.hibernate.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 800, 800);
        stage.setScene(scene);
        stage.show();

/*
        PersonTable table = new PersonTable();
        borderPane.setCenter(borderPane);
*/
    }
    public static void main(String[] args) {
        launch(args);
    }
}