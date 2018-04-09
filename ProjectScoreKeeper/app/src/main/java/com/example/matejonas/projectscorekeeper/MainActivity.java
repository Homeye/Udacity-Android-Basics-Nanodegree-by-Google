package com.example.matejonas.projectscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int round = 1;

    private int playerOneScore = 0;

    private int playerOneRocks = 0;

    private int playerOnePapers = 0;

    private int playerOneScissors = 0;

    private int playerTwoScore = 0;

    private int playerTwoRocks = 0;

    private int playerTwoPapers = 0;

    private int playerTwoScissors = 0;

    private String welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
          Initialize the welcome message from styles.xml.
         */
        welcomeMessage = getString(R.string.welcome_message);
    }

    /**
     * Increase the number of rocks for Player One.
     */
    public void addOneRockForPlayerOne(View view) {
        playerOneRocks++;
        displayPlayerOneRocks(playerOneRocks);
        isNextRound();
    }

    /**
     * Displays the number of rocks for Player One.
     */
    public void displayPlayerOneRocks(int score) {
        TextView scoreView = findViewById(R.id.player_one_rocks);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the number of papers for Player One.
     */
    public void addOnePaperForPlayerOne(View view) {
        playerOnePapers++;
        displayPlayerOnePapers(playerOnePapers);
        isNextRound();
    }

    /**
     * Displays the number of papers for Player One.
     */
    public void displayPlayerOnePapers(int score) {
        TextView scoreView = findViewById(R.id.player_one_papers);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the number of scissors for Player One.
     */
    public void addOneScissorForPlayerOne(View view) {
        playerOneScissors++;
        displayPlayerOneScissors(playerOneScissors);
        isNextRound();
    }

    /**
     * Displays the number of scissors for Player One.
     */
    public void displayPlayerOneScissors(int score) {
        TextView scoreView = findViewById(R.id.player_one_scissors);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of won rounds for Player One.
     */
    public void displayPlayerOneScore(int score) {
        TextView scoreView = findViewById(R.id.player_one_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the number of rocks for Player Two.
     */
    public void addOneRockForPlayerTwo(View view) {
        playerTwoRocks++;
        displayPlayerTwoRocks(playerTwoRocks);
        isNextRound();
    }

    /**
     * Displays the number of rocks for Player Two.
     */
    public void displayPlayerTwoRocks(int score) {
        TextView scoreView = findViewById(R.id.player_two_rocks);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the number of papers for Player Two.
     */
    public void addOnePaperForPlayerTwo(View view) {
        playerTwoPapers++;
        displayPlayerTwoPapers(playerTwoPapers);
        isNextRound();
    }

    /**
     * Displays the number of papers for Player Two.
     */
    public void displayPlayerTwoPapers(int score) {
        TextView scoreView = findViewById(R.id.player_two_papers);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the number of scissors for Player Two.
     */
    public void addOneScissorForPlayerTwo(View view) {
        playerTwoScissors++;
        displayPlayerTwoScissors(playerTwoScissors);
        isNextRound();
    }

    /**
     * Displays the number of scissors for Player Two.
     */
    public void displayPlayerTwoScissors(int score) {
        TextView scoreView = findViewById(R.id.player_two_scissors);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of won rounds for Player Two.
     */
    public void displayPlayerTwoScore(int score) {
        TextView scoreView = findViewById(R.id.player_two_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the number of the current round.
     */
    public void addOneRound() {
        playerOneRocks = 0;
        playerOnePapers = 0;
        playerOneScissors = 0;
        playerTwoRocks = 0;
        playerTwoPapers = 0;
        playerTwoScissors = 0;
        round++;
        displayPlayerOneScore(playerOneScore);
        displayPlayerOneRocks(playerOneRocks);
        displayPlayerOnePapers(playerOnePapers);
        displayPlayerOneScissors(playerOneScissors);
        displayPlayerTwoScore(playerTwoScore);
        displayPlayerTwoRocks(playerTwoRocks);
        displayPlayerTwoPapers(playerTwoPapers);
        displayPlayerTwoScissors(playerTwoScissors);
        displayCurrentRound(round);
    }

    /**
     * Displays the current round.
     */
    public void displayCurrentRound(int score) {
        TextView scoreView = findViewById(R.id.round);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Changes the message field under the score table.
     */
    public void setMessage(String message) {
        TextView messageView = findViewById(R.id.message);
        messageView.setText(message);
    }

    /**
     * Resets the match.
     */
    public void newMatch(View view) {
        playerOneScore = 0;
        playerTwoScore = 0;
        playerOneRocks = 0;
        playerOnePapers = 0;
        playerOneScissors = 0;
        playerTwoRocks = 0;
        playerTwoPapers = 0;
        playerTwoScissors = 0;
        round = 1;
        displayPlayerOneScore(playerOneScore);
        displayPlayerOneRocks(playerOneRocks);
        displayPlayerOnePapers(playerOnePapers);
        displayPlayerOneScissors(playerOneScissors);
        displayPlayerTwoScore(playerTwoScore);
        displayPlayerTwoRocks(playerTwoRocks);
        displayPlayerTwoPapers(playerTwoPapers);
        displayPlayerTwoScissors(playerTwoScissors);
        displayCurrentRound(round);
        setMessage(welcomeMessage);
    }

    /**
     * Determines if the round is finished.
     */
    public boolean isRoundFinished() {
        return (playerOneRocks + playerOnePapers + playerOneScissors + playerTwoRocks + playerTwoPapers + playerTwoScissors) == 5;
    }

    /**
     * Summarizes the previous round.
     */
    public String lastRoundMessage() {
        String lastRoundMessage = "";
        if ((playerOneRocks + playerOnePapers + playerOneScissors) > (playerTwoRocks + playerTwoPapers + playerTwoScissors)) {
            lastRoundMessage += "Player One won the last round with " + playerOneRocks + " rock(s), " + playerOnePapers + " paper(s), " + playerOneScissors + " scissor(s)!";
        }
        if ((playerOneRocks + playerOnePapers + playerOneScissors) < (playerTwoRocks + playerTwoPapers + playerTwoScissors)) {
            lastRoundMessage += "Player Two won the last round with " + playerTwoRocks + " rock(s), " + playerTwoPapers + " paper(s), " + playerTwoScissors + " scissor(s)!";
        }
        return lastRoundMessage;
    }

    /**
     * If necessary, it will launch a new round.
     */
    public void isNextRound() {
        if (isRoundFinished()) {
            setMessage(lastRoundMessage());
            if ((playerOneRocks + playerOnePapers + playerOneScissors) > (playerTwoRocks + playerTwoPapers + playerTwoScissors)) {
                playerOneScore++;
            }
            if ((playerOneRocks + playerOnePapers + playerOneScissors) < (playerTwoRocks + playerTwoPapers + playerTwoScissors)) {
                playerTwoScore++;
            }
            addOneRound();
        }
    }

}
