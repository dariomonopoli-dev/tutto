package Gamestate;

import Cards.Deck;
import Player.Player;
import Round.Round;

import java.util.ArrayList;

public class Gameplay {
    private static void startGame() {

        Displayer.displayWelcomeScreen();

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
