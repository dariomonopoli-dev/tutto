import Helper.GameInitailizer;

import java.util.ArrayList;

public class Gameplay {
    private void startGame() {
        // Instanciating an ArrayList of all Player Instances
        String[] playerNames = GameInitailizer.getPlayerNames();

        ArrayList<Player> playerInstances = new ArrayList<>();
        for(String playerName : playerNames) {
            playerInstances.add(new Player(playerName));
        }

        int maxScore = GameInitailizer.getMaxScore();
    }

    public static void main(String[] args) {
        //startGame();
    }
}
