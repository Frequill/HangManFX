package MainPKG;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartScreenController extends GUI{

    @FXML
    private Label welcomeToHangmanFxLabel;

    @FXML
    private Button infoButton;

    @FXML
    private Button playGameButton;

    @FXML
    private Button quitButton;


    @FXML
    void playGame(ActionEvent event) {
        startGame();
    }

    @FXML
    void quitGame(ActionEvent event) {
        welcomeToHangmanFxLabel.setText("Come back again soon! :)");
        infoButton.setVisible(false);
        playGameButton.setVisible(false);
        quitButton.setVisible(false);
        delay(4000, ()->System.exit(0)); // Waits 4 seconds so that user may read goodbye message!
    }

    @FXML
    void showInfo(ActionEvent event) {
        changeToInfoScene();
    }
}
