package com.example.pomodoroguitest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
    Button pauseButton, startButton, skipButton;
    Text statusText = new Text();
    static Text timerText = new Text();
    int time = 1500;
    int WIDTH = 600;
    int HEIGHT = 600;
    Font normalFont;
    TimerControls timerControls = new TimerControls();
    boolean studyTime;
    HBox buttonBox = new HBox();
    VBox timerBox = new VBox();
    static int rectW = 300;
    static int rectH = 40;
    static int rectX = 40;
    static int rectY = 0;
    static Rectangle rectangle = new Rectangle(rectX, rectY, rectW, rectH);


    @Override
    public void start(Stage stage) throws IOException{
        studyTime = true;
        VBox root = new VBox();
        //StackPane root = new StackPane();
        stage.setTitle("Pomodoro");
        root.getChildren().add(timerBox);
        root.getChildren().add(buttonBox);

        normalFont = Font.font("Comic Sans MS", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        timerBox.setSpacing(20);
        timerBox.setPadding(new Insets(HEIGHT/4, WIDTH/2-50, HEIGHT/4, WIDTH/2-50));

        //Distance between nodes
        buttonBox.setSpacing(20);
        //Distance around box
        buttonBox.setPadding(new Insets(HEIGHT/4, 30, HEIGHT/4, 30));   //Insets is top, right, bottom, left.
        buttonBox.setStyle("-fx-background-color: #336699;");

        pauseButton = new Button();
        pauseButton.setText("Pause");
        pauseButton.setOnAction(this::handle);
        pauseButton.setFont(normalFont);

        startButton = new Button();
        startButton.setText("Start");
        startButton.setOnAction(this::handle);
        startButton.setFont(normalFont);

        skipButton = new Button();
        skipButton.setText("Skip");
        skipButton.setOnAction(this::handle);
        skipButton.setFont(normalFont);

        statusText.setText("Press start to begin!");
        statusText.setFont(normalFont);

        timerText.setText("Timer");
        timerText.setFont(normalFont);

        rectangle.setFill(Color.LIMEGREEN);

        buttonBox.getChildren().addAll(pauseButton, startButton, skipButton, statusText);
        timerBox.getChildren().addAll(timerText, rectangle);

        //So it's stage contains a scene which contains the panes.
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void setTime(String timeTxt){
        timerText.setText(timeTxt);
    }

    public static void setRectangleWidth(float fractionTime){
        rectangle.setWidth(rectW * fractionTime);
    }

    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == pauseButton){
            if(timerControls.getTimerOn()){
                timerControls.setTimerOn(false);
                pauseButton.setText("Play");
            }else{
                timerControls.setTimerOn(true);
                pauseButton.setText("Pause");
            }
        }else if(event.getSource() == startButton){
            if(studyTime == true){
                timerBox.setStyle("-fx-background-color: #B30059");
                timerControls.startTimer(1500, studyTime);
                studyTime = false;
            }else{
                //https://rgbcolorcode.com/color/008055
                timerBox.setStyle("-fx-background-color: #008055;");
                timerControls.startTimer(300, studyTime);
                studyTime = true;
            }
            timerControls.setTimerOn(true);
        }else if(event.getSource() == skipButton){
            //Don't need to change the studyTime variable here as it's already changed under startButton.
            timerControls.setTimerOn(false);

        }

    }

    public static void main(String[] args) {
        launch();
    }
}