package com.example.pomodoroguitest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();
        //So it's stage contains a scene which contains the panes.
    }

    public static void main(String[] args) {
        launch();
    }
}