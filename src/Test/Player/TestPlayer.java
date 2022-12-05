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
    void TestGetPlayerName() {
        final Player player1 = new Player("Philipp");

        assertEquals("Philipp", player1.getPlayerName());
    }

    @Test
    void TestGetPlayerScore() {
        final Player player1 = new Player("Philipp");
        assertEquals(0, player1.getPlayerScore());
    }

    @Test
    void TestIncreasePlayerScore() {
        final Player player1 = new Player("Docks");
        player1.increasePlayerScore(11);
        assertEquals(player1.getPlayerScore(), 11);
    }

    @Test
    void TestIncreasePlayerScoreExceptionMsg() {
        try {
            final Player player1 = new Player("Docks");
            player1.increasePlayerScore(-11);
        }
        catch (IllegalArgumentException e) {
            String message = "Score must be positive!";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    void TestIncreasePlayerScoreException() {
        final Player player1 = new Player("Docks");
        assertThrows(IllegalArgumentException.class, () -> player1.increasePlayerScore(-11));
    }

    @Test
    void TestDecreasePlayerScoreby1000() {
        final Player player1 = new Player("Ham");
        player1.decreasePlayerScoreBy1000();
        assertEquals(-1000, player1.getPlayerScore());
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
    void TestGetChoiceContinueRollYes(){
        String userInput = """
                A
                R
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Elend Venture");
        assertTrue(player1.getChoiceContinueRoll());
    }

    @Test
    void TestGetChoiceContinueRollNo(){
        String userInput = """
                A
                E
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Lord Ruler");
        assertFalse(player1.getChoiceContinueRoll());
    }

    @Test
    void TestGetChoiceAnotherRound() {
        String userInput = """
                R
                Y
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Sazed");
        assertTrue(player1.getChoiceAnotherRoll());
    }

    @Test
    void TestGetChoiceDisplayScores() {
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
    void TestGetChoiceDice() {
        String userInput = """
                z
                1,2,3,4,5,6
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Philipp");
        assertEquals("1,2,3,4,5,6", player1.getChoiceDice(6));
    }

    @Test
    void TestGetAnotherRoll() {
        String userInput = """
                r
                R
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("Philipp");
        player1.getAnotherRoll();
    }

    @Test
    void TestGetAnotherRollOutput(){
        String userInput = """
                a
                R
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final Player player1 = new Player("OreSeur");
        player1.getAnotherRoll();
        String[] expectedOutput = {
                // invalid Input
                "OreSeur, enter \u001B[0;93mR\u001B[0m to roll your dice again:",
                // Empty input
                "\u001B[31mInvalid input =(\u001B[0m",
                "Please enter '\u001B[0;93mR\u001B[0m' to roll the dice.",};

        String[] lines = outputStreamCaptor.toString().split(System.lineSeparator());
        // checkout output
        assertArrayEquals(expectedOutput,lines);
    }

    @Test
    void CompareTo() {
        Player player1 = new Player("Dario");
        assertEquals(0, player1.compareTo(player1));
    }
}