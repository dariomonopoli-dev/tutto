package Gamestate;

import Cards.Deck;
import Player.Player;
import Round.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gameplay {

    private static void waitForEnter() {
        Scanner getEnter = new Scanner(System.in);
        System.out.println("Press " + Displayer.ANSI_YELLOW + "Enter" + Displayer.ANSI_RESET + " to Start the game!");
        getEnter.nextLine();  // Read user input
    }

    private static void startGame() {

        Displayer.displayWelcomeScreen();
        waitForEnter();

        // Initialization
        ArrayList<Player> players = GameInitializer.getPlayers();
        int winningScore = GameInitializer.getWinningScore();
        Deck cardDeck = Deck.getInstance();

        // Gameplay
        List<Player> listOfLeaders = new ArrayList<>();
        boolean winningScoreReached = false;
        while (!winningScoreReached) {
            Round.playRound(players, cardDeck);
            listOfLeaders = Round.setHighestScoringPlayer(players);
            if (listOfLeaders.get(0).getPlayerScore() >= winningScore) {
                winningScoreReached = true;
            }
        }

        // GameEnd
        Displayer.displayWinnerScreen(listOfLeaders, players);
    }

    public static void main(String[] args) {
        startGame();
    }
}
