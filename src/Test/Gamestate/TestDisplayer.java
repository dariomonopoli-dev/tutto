package Test.Gamestate;

import Cards.CardCloverleaf;
import Gamestate.Displayer;
import Player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;



class TestDisplayer extends Displayer{

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void TestDisplayAllDice() {
        ArrayList<Integer> dice = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        displayDice(dice);

        String expectedOutput1 = "┌─────────┐  ┌─────────┐  ┌─────────┐  ┌─────────┐  ┌─────────┐  ┌─────────┐";
        String expectedOutput2 = "│         │  │  ■      │  │  ■      │  │  ■   ■  │  │  ■   ■  │  │  ■   ■  │";
        String expectedOutput3 = "│    ■    │  │         │  │    ■    │  │         │  │    ■    │  │  ■   ■  │";
        String expectedOutput4 = "│         │  │      ■  │  │      ■  │  │  ■   ■  │  │  ■   ■  │  │  ■   ■  │";
        String expectedOutput5 = "└─────────┘  └─────────┘  └─────────┘  └─────────┘  └─────────┘  └─────────┘";

        assertTrue(outputContent.toString().contains(expectedOutput1));
        assertTrue(outputContent.toString().contains(expectedOutput2));
        assertTrue(outputContent.toString().contains(expectedOutput3));
        assertTrue(outputContent.toString().contains(expectedOutput4));
        assertTrue(outputContent.toString().contains(expectedOutput5));
    }

    @Test
    void displayScoresZeroPoints() {
        final String expectedOutput1 = "│ " + BLUE_BOLD + "Player " + ANSI_RESET + "            │ " + BLUE_BOLD + "Score" + ANSI_RESET + "       │";
        final String expectedOutput2 = "│ Hamm               │ 0           │";
        final String expectedOutput3 = "│ Marsh              │ 0           │";
        final String expectedOutput4 = "│ Sazed              │ 0           │";

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Sazed"));
        players.add(new Player("Hamm"));
        players.add(new Player("Marsh"));

        displayScores(players);

        assertTrue(outputContent.toString().contains(expectedOutput1));
        assertTrue(outputContent.toString().contains(expectedOutput2));
        assertTrue(outputContent.toString().contains(expectedOutput3));
        assertTrue(outputContent.toString().contains(expectedOutput4));
    }
    @Test
    void displayScoresIncreasedPoints() {

        final String expectedOutput1 = "│ Hamm               │ 2555        │";
        final String expectedOutput2 = "│ Marsh              │ 4300        │";
        final String expectedOutput3 = "│ Sazed              │ 6000        │";

        ArrayList<Player> players = new ArrayList<>();
        Player sazed = new Player("Sazed");
        Player hamm = new Player("Hamm");
        Player marsh = new Player("Marsh");
        sazed.increasePlayerScore(6000);
        players.add(sazed);
        hamm.increasePlayerScore(2555);
        players.add(hamm);
        marsh.increasePlayerScore(4300);
        players.add(marsh);

        displayScores(players);

        assertTrue(outputContent.toString().contains(expectedOutput1));
        assertTrue(outputContent.toString().contains(expectedOutput2));
        assertTrue(outputContent.toString().contains(expectedOutput3));
    }

    @Test
    void TestDisplayCardClover() {
        final CardCloverleaf clover = CardCloverleaf.getInstance();
        String expectedOutput = clover.getGraphicalRepresentation();

        displayCard(clover);

        assertTrue(outputContent.toString().contains(expectedOutput));
    }

    @Test
    void TestDisplayWelcomeScreen() {
        String expectedOutput1 = ANSI_BLUE+ """
            ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ████████╗██╗   ██╗████████╗████████╗ ██████╗
            ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══██╔══╝██║   ██║╚══██╔══╝╚══██╔══╝██╔═══██╗
            ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝       ██║   ╚██████╔╝   ██║      ██║   ╚██████╔╝
             ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝        ╚═╝    ╚═════╝    ╚═╝      ╚═╝    ╚═════╝""";
        String expectedOutput2 = "Developed by " + ANSI_GREEN + "Valentin Meyer" + ANSI_BLUE + ", " + ANSI_GREEN + "Dario Monopoli" + ANSI_BLUE
                + ", " + ANSI_GREEN + "Lennart Töllke" + ANSI_BLUE + " and " + ANSI_GREEN + "Remo Wiget"+ANSI_RESET;
        displayWelcomeScreen();

        assertTrue(outputContent.toString().contains(expectedOutput1));
        assertTrue(outputContent.toString().contains(expectedOutput2));
    }

    @Test
    void displayWinnerScreen() {

        final String expectedOutput1 = GREEN_BOLD_BRIGHT +"""
            ██╗    ██╗███████╗    ██╗  ██╗ █████╗ ██╗   ██╗███████╗     █████╗     ██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ ██╗██╗
            ██║    ██║██╔════╝    ██║  ██║██╔══██╗██║   ██║██╔════╝    ██╔══██╗    ██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗██║██║
            ██║ █╗ ██║█████╗      ███████║███████║██║   ██║█████╗      ███████║    ██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝██║██║
            ██║███╗██║██╔══╝      ██╔══██║██╔══██║╚██╗ ██╔╝██╔══╝      ██╔══██║    ██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗╚═╝╚═╝
            ╚███╔███╔╝███████╗    ██║  ██║██║  ██║ ╚████╔╝ ███████╗    ██║  ██║    ╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║██╗██╗
             ╚══╝╚══╝ ╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝    ╚═╝  ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝"""+ ANSI_RESET;
        final String expectedOutput2 = "Congratulations to: ";
        final String expectedOutput3 = "Sazed";

        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> winners = new ArrayList<>();
        Player sazed = new Player("Sazed");
        Player hamm = new Player("Hamm");
        Player marsh = new Player("Marsh");

        players.add(sazed);
        players.add(hamm);
        players.add(marsh);
        winners.add(sazed);

        displayWinnerScreen(winners, players);

        assertTrue(outputContent.toString().contains(expectedOutput1));
        assertTrue(outputContent.toString().contains(expectedOutput2));
        assertTrue(outputContent.toString().contains(expectedOutput3));
    }
}