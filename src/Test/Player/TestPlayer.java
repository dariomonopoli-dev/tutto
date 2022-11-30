package Test.Player;

import Player.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPlayer {

    @Test
    void getPlayerName() {
        final Player player1 = new Player("Philipp");
        assertEquals("Philipp", player1.getPlayerName());
    }

    @Test
    void getPlayerScore() {
        final Player player1 = new Player("Philipp");
        assertEquals(0, player1.getPlayerScore());
    }

    @Test
    void updatePlayerScore() {
        final Player player1 = new Player("Philipp");
        player1.updatePlayerScore(1000);
        assertEquals(1000, player1.getPlayerScore());

    }

    @Test
    void subtractPlayerScore() {
        final Player player1 = new Player("Philipp");
        player1.updatePlayerScore(1000);
        player1.subtractPlayerScore(1000);
        assertEquals(0, player1.getPlayerScore());
    }

    @Test
    void getChoiceContinueRoll() {
    }

    @Test
    void getChoiceAnotherRound() {
    }

    @Test
    void getChoiceDisplayScores() {
    }

    @Test
    void getChoiceDice() {
    }

    @Test
    void getAnotherRoll() {
    }

    @Test
    void compareTo() {
        Player player1 = new Player("Dario");
        assertEquals(0, player1.compareTo(player1));
    }
}