package MainPKG;

import GameLogic.HangManGame;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    public static Stage mainStage;

    public void startGame() {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("GameScene.fxml"));
        Scene scene = null;
        try {scene = new Scene(fxmlLoader.load());} catch (IOException e) {e.printStackTrace();}

        mainStage.setTitle("Hang manFX™");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void changeToStartScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StartupScene.fxml"));
        Scene scene = null;
        try {scene = new Scene(fxmlLoader.load());} catch (IOException e) {e.printStackTrace();}

        mainStage.setTitle("StartScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void changeToInfoScene() {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("InfoScene.fxml"));
        Scene scene = null;
        try {scene = new Scene(fxmlLoader.load());} catch (IOException e) {e.printStackTrace();}

        mainStage.setTitle("InfoScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     This method allows me to execute basic "thread-sleeps" since JavaFX has a tendency to make this process frustrating...
     */
    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }


    @Override
    public void start(Stage primaryStage) {
        HangManGame hangManGame = new HangManGame("Julius");
        hangManGame.playGame();



        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StartupScene.fxml"));
        Scene scene = null;
        try {scene = new Scene(fxmlLoader.load());} catch (IOException e) {e.printStackTrace();}

        mainStage = primaryStage;
        mainStage.setTitle("StartScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}