package Gamestate;

import Player.Player;
import java.util.ArrayList;

public class Gameplay {
    private static void startGame() {

        ArrayList<Player> players = GameInitializer.getPlayers();
        int winningScore = GameInitializer.getWinningScore();
    }

    public static void main(String[] args) {
        startGame();
    }
}
