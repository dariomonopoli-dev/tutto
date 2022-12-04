package Test.Player;

import Player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;



class TestPlayer {

    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

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
        String userInput = "R\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Philipp");
        assertTrue(player1.getChoiceContinueRoll());
    }

    @Test
    void getChoiceAnotherRound() {
        String userInput = """
                R
                Y
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Philipp");
        assertTrue(player1.getChoiceAnotherRoll());
    }

    @Test
    void getChoiceDisplayScores() {
        String userInput = """
                a
                D
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Philipp");
        assertTrue(player1.getChoiceDisplayScores());
    }

    @Test
    void GetChoiceDice() {
        String userInput = "1,2,3,4,5,6\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Philipp");
        assertEquals("1,2,3,4,5,6", player1.getChoiceDice(6));
    }

    @Test
    void CompareTo() {
        Player player1 = new Player("Dario");
        assertEquals(0, player1.compareTo(player1));
    }
}