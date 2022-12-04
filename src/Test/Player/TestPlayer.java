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
        player1.increasePlayerScore(1000);
        assertEquals(1000, player1.getPlayerScore());

    }

    @Test
    void subtractPlayerScore() {
        final Player player1 = new Player("Philipp");
        player1.increasePlayerScore(1000);
        player1.decreasePlayerScoreBy1000();
        assertEquals(0, player1.getPlayerScore());
    }

    @Test
    void getChoiceContinueRoll() {
        System.out.println("Input first any letter then R to pass this test");
        final Player player1 = new Player("Philipp");
        assertEquals(true, player1.getChoiceContinueRoll());
    }

    @Test
    void getChoiceAnotherRound() {
        System.out.println("Input first any letter then Y to pass this test");
        final Player player1 = new Player("Philipp");
        assertEquals(true, player1.getChoiceAnotherRoll());
    }

    @Test
    void getChoiceDisplayScores() {
        System.out.println("Input first any letter then D to pass this test");
        final Player player1 = new Player("Philipp");
        assertEquals(true, player1.getChoiceDisplayScores());
    }

    @Test
    void getChoiceDice() {
        System.out.println("Input 1,2,3,4,5,6 to pass this test");
        final Player player1 = new Player("Philipp");
        assertEquals("1,2,3,4,5,6", player1.getChoiceDice(6));

    }

    @Test
    void compareTo() {
        Player player1 = new Player("Dario");
        assertEquals(0, player1.compareTo(player1));
    }
}