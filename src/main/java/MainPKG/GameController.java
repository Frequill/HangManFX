package MainPKG;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController extends GUI{

    @FXML
    public Label lengthLabel;

    @FXML
    public Label blankWordLabel;

    // Default-value of "playerGuess" is a whitespace so game can recognize when an input has been made
    private char playerGuess = ' ';

    public void setPlayerGuess(char playerGuess) {
        this.playerGuess = playerGuess;
    }

    public char getPlayerGuess() {
        return playerGuess;
    }

    @FXML
    private TextField gameInputField;

    public TextField getGameInputField() {
        return gameInputField;
    }

    @FXML
    private Label greetAndPlayerName;

    @FXML
    void makeGuess(ActionEvent event) {
        setPlayerGuess(getGameInputField().getText().charAt(0));
        System.out.println(getGameInputField().getText().charAt(0)); //TESTING
    }

    @FXML
    void surrender(ActionEvent event) {
        greetAndPlayerName.setText("YOU ARE A FILTHY QUITTER!");
        delay(4000, this::changeToStartScene);
    }
}
