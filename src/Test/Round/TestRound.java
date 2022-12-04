package Test.Round;

import Cards.*;
import Player.Player;
import Round.Round;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRound {

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
    void TestOneHighestScoringPlayer() {
        Player player1 = new Player("Philipp");
        Player player2 = new Player("Johnny");
        player2.increasePlayerScore(1000);
        List<Player>  allPlayers = Arrays.asList(player1, player2);
        List<Player>  expected = Arrays.asList(player2);
        List<Player> actual = Round.setHighestScoringPlayer(allPlayers);
        assertTrue(expected.size() == actual.size() &&
                expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    void TestTwoHighestScoringPlayers() {
        Player player1 = new Player("Philipp");
        Player player2 = new Player("Johnny");
        player1.increasePlayerScore(1000);
        player2.increasePlayerScore(1000);
        List<Player>  allPlayers = Arrays.asList(player1, player2);
        List<Player>  expected = Arrays.asList(player1, player2);
        List<Player> actual = Round.setHighestScoringPlayer(allPlayers);
        assertTrue(expected.size() == actual.size() &&
                expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    void TestPlayStopCard() {
        String userInput = """
                            D
                            R
                            """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        Deck deck = new Deck(CardStop.getInstance());
        final Player player1 = new Player("Straff Wager");
        final List<Player> players = Arrays.asList(player1);
        Round.playRound(players, deck);
        assertEquals(0, player1.getPlayerScore());
    }

//    @Test
//    void TestPlayBonusCard() {
//        String userInput = """
//                        R
//                        1
//                        2
//                        3
//                        4
//                        5
//                        6
//                        1,2,3
//                        1,2,4
//                        1,2,5
//                        1,2,6
//                        1,3,4
//                        1,3,5
//                        1,3,6
//                        1,4,5
//                        1,4,6
//                        1,5,6
//                        2,3,4
//                        2,3,5
//                        2,3,6
//                        2,4,5
//                        2,4,6
//                        2,5,6
//                        3,4,5
//                        3,4,6
//                        3,5,6
//                        4,5,6
//                        E
//                        """;
//        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(testIn);
//        Deck deck = new Deck(CardBonus.getInstance(200));
//        final Player player1 = new Player("Elend Venture");
//        final List<Player> players = Arrays.asList(player1);
//        Round.playRound(players, deck);
//    }
//
//    @Test
//    void TestPlayX2Card() {
//        String userInput = """
//                        R
//                        1
//                        2
//                        3
//                        4
//                        5
//                        6
//                        1,2,3
//                        1,2,4
//                        1,2,5
//                        1,2,6
//                        1,3,4
//                        1,3,5
//                        1,3,6
//                        1,4,5
//                        1,4,6
//                        1,5,6
//                        2,3,4
//                        2,3,5
//                        2,3,6
//                        2,4,5
//                        2,4,6
//                        2,5,6
//                        3,4,5
//                        3,4,6
//                        3,5,6
//                        4,5,6
//                        E
//                        """;
//        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(testIn);
//        Deck deck = new Deck(CardX2.getInstance());
//        final Player player1 = new Player("Cett");
//        final List<Player> players = Arrays.asList(player1);
//        Round.playRound(players, deck);
//    }

//    @Test
//    void TestPlayPlusMinusCard() {
//        String userInput = testInputDiceChoice;
//        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(testIn);
//        Deck deck = new Deck(CardPlusMinus.getInstance());
//        final Player player1 = new Player("Sazed");
//        final List<Player> players = Arrays.asList(player1);
//        Round.playRound(players, deck);
//    }
//
//    @Test
//    void TestPlayCloverLeafCard() {
//        String userInput = testInputDiceChoice;
//        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(testIn);
//        Deck deck = new Deck(CardCloverleaf.getInstance());
//        final Player player1 = new Player("Ham");
//        final List<Player> players = Arrays.asList(player1);
//        Round.playRound(players, deck);
//    }
//
//    @Test
//    void TestPlayFireWorkCard() {
//        String userInput = testInputOnlyR;
//        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(testIn);
//        Deck deck = new Deck(CardFireworks.getInstance());
//        final Player player1 = new Player("Breeze");
//        final List<Player> players = Arrays.asList(player1);
//        Round.playRound(players, deck);
//    }

}