package Gamestate;

import Cards.Deck;
import Player.Player;
import Round.Round;

import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

    private static void waitForEnter(String message) {
        Scanner getEnter = new Scanner(System.in);
        System.out.println(Displayer.ANSI_YELLOW + message + Displayer.ANSI_RESET);
        getEnter.nextLine();  // Read user input
    }

    private static void startGame() {

        Displayer.displayWelcomeScreen();
        waitForEnter("Press Enter to Start the game!");

        // Initialization
        ArrayList<Player> players = GameInitializer.getPlayers();
        int winningScore = GameInitializer.getWinningScore();
        Deck cardDeck = new Deck();

        // Gameplay
        boolean winningScoreReached = false;
        while (!winningScoreReached) {
            Round.playRound(players, cardDeck);
            for (Player player : players) {
                if (player.getPlayerScore() >= winningScore) {
                    winningScoreReached = true;
                    break;
                }
            }
        }

        // GameEnd
        int maxScore = 0;
        for (Player player : players) {
            if (player.getPlayerScore() > maxScore) {
                String winnerName = player.getPlayerName();
                maxScore = player.getPlayerScore();
            }
        }
        Displayer.displayWinnerScreen();
    }

    public static void main(String[] args) {
        startGame();
    }
}
