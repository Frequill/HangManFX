package GameLogic;

import MainPKG.GUI;
import MainPKG.GameController;

import java.util.ArrayList;
import java.util.List;

public class HangManGame extends GameController {

    // Game has made great progress but is currently crashing... requires testing!



    private String playerName;
    private int playerLife = 10;
    // This arraylist holds an "_" for every character that the player needs to guess, this can later be displayed in GUI
    private List<Character> hiddenGuessWord = new ArrayList<>();
    // This arraylist holds every character player needs to guess
    private List<Character> guessWord = new ArrayList<>();
    // This arraylist holds every possible word that can be used as a "guessWord" or a word that the player needs to guess...
    private List<String> allWords = new ArrayList<>();

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerLife() {
        return playerLife;
    }

    public void setPlayerLife(int playerLife) {
        this.playerLife = playerLife;
    }

    public HangManGame(String playerName) {
        this.playerName = playerName;
    }

    public void makeAllWordsList(){ // Fills list "allWords" with potential words that player can be asked to guess during gameplay!
        allWords.add("testing");
    }

    public void playGame() {
        makeAllWordsList();

        System.out.println("WE HAVE ENTERED THE GAME");

        String currentWord = allWords.get(0);

        for (int i = 0; i < currentWord.length(); i++) {
            guessWord.add(currentWord.charAt(i));
        }
        for (int i = 0; i < currentWord.length(); i++) {
            hiddenGuessWord.add(i, '_');
        }

        System.out.println(currentWord);                    // TESTING PURPOSE
        System.out.println(hiddenGuessWord.toString());     // TESTING PURPOSE

        lengthLabel.setText("The word that you need to guess is " + guessWord.size() + " letters long!");  // Currently, causes crashing...
        blankWordLabel.setText(hiddenGuessWord.toString());


        if (getPlayerGuess() != ' ') {

            // If-case inside if-case checks if users input exists in "guessWord". If it does, it will be added to "blankWord"
            for (int i = 0; i < guessWord.size(); i++) {
                if (getPlayerGuess() == guessWord.get(i)) {

                    for (int j = 0; j < guessWord.size(); j++) {
                        if (getPlayerGuess() == guessWord.get(j)) {
                            hiddenGuessWord.set(j, getPlayerGuess());

                            System.out.println("CORRECT");
                        } else {
                            System.out.println("Incorrect...");
                        } // delete this row if testing is done
                        // trueGuess = true; // Your guess was correct!
                    }
                }
            }
        }
    }




}