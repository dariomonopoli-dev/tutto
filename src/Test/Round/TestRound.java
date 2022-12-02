package Test.Round;

import Player.Player;
import Round.Round;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestRound {
    @Test
    void setHighestScoringPlayer() {
        Round r = new Round();
        Player player1 = new Player("Philipp");
        Player player2 = new Player("Johnny");
        player2.updatePlayerScore(1000);
        ArrayList<Player>  allPlayers = new ArrayList<>();
        allPlayers.add(0, player1);
        allPlayers.add(1, player2);
        ArrayList<Player>  highestScoring = new ArrayList<>();
        highestScoring.add(0, player2);

        assertEquals(highestScoring, r.setHighestScoringPlayer(allPlayers));
    }

}