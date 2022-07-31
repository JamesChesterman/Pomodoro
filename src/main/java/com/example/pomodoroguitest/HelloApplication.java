package com.example.pomodoroguitest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.event.EventHandler;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler<ActionEvent>{
    Button button;
    Button pauseButton;
    Text statusText = new Text();
    Text timerText = new Text();
    int time = 1500;
    int WIDTH = 600;
    int HEIGHT = 600;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);
    Font normalFont;

    @Override
    public void start(Stage stage) throws IOException{
        VBox root = new VBox();
        HBox buttonBox = new HBox();
        HBox timerBox = new HBox();
        //StackPane root = new StackPane();
        stage.setTitle("Pomodoro");
        root.getChildren().add(timerBox);
        root.getChildren().add(buttonBox);

        timerBox.setSpacing(20);
        timerBox.setPadding(new Insets(HEIGHT/4, 12, HEIGHT/4, 12));

        //Distance between nodes
        buttonBox.setSpacing(20);
        //Distance around box
        buttonBox.setPadding(new Insets(HEIGHT/4, 12, HEIGHT/4, 12));   //Insets is top, right, bottom, left.
        buttonBox.setStyle("-fx-background-color: #336699;");

        normalFont = Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        /*
        button = new Button();
        button.setText("This is a button");
        root.getChildren().add(button);
        button.setOnAction(this::handle);
        */

        pauseButton = new Button();
        pauseButton.setText("Pause");
        pauseButton.setOnAction(this::handle);

        statusText.setText("Press play to begin!");

        timerText.setText(hoursString + ":" + minutesString + ":" + secondsString);
        timerText.setFont(normalFont);

        buttonBox.getChildren().addAll(pauseButton, statusText);
        timerBox.getChildren().add(timerText);

        //So it's stage contains a scene which contains the panes.
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == button){
            button.setText("Hi");
        }else if(event.getSource() == pauseButton){

        }

    }

    public static void main(String[] args) {
        launch();
    }
}