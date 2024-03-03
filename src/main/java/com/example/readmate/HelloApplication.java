package com.example.readmate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.Event;

import java.io.IOException;


public class HelloApplication extends Application {

    Button firstButton = new Button("CLICK TO START");
    int counter = 0;
    long starttime = 0;
    long endtime = 0;
    float timeDifference = 0f;
    Label speedTracker;

    @Override
    public void start(Stage stage) throws IOException {



        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1280, 960);
        firstButton.setPrefWidth(200);
        firstButton.setOnAction(event -> buttonClick(event));
        speedTracker = new Label();


        root.getChildren().addAll(firstButton,speedTracker);
        StackPane.setAlignment(speedTracker,Pos.TOP_CENTER);

        stage.setTitle("ReadMate");
        stage.setScene(scene);
        stage.show();
    }

    private void buttonClick(ActionEvent event) {

        if(event.getSource() == firstButton) {
            counter++;
            if(starttime == 0) {
                starttime = System.currentTimeMillis();
            } else {
                endtime = System.currentTimeMillis();
                timeDifference = (endtime - starttime)/(float)1000;
                starttime = endtime;
            }
        }
        firstButton.setText(String.valueOf(counter));
        if(timeDifference<0.01) {
            speedTracker.setText("You're doing well " + timeDifference + "s");
        } else {
            speedTracker.setText("GO FASTER  " + timeDifference + "s");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}