package Test.Gamestate;

import Gamestate.GameInitializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestGameInitializer extends GameInitializer {

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
    void getPlayerNumberValidNumber() {
        String userInput = "3\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        assertEquals(3,GameInitializer.getPlayerNumber());
    }

    @Test
    void getPlayerNumberInvalidsFirst() {
        String userInput = """
                1
                5
                afb
                2
                """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        assertEquals(2,GameInitializer.getPlayerNumber());
    }

        @Test
    void TestGetPlayerNameValidNames() {
        String userInput = "Kelsier\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        assertEquals("Kelsier",GameInitializer.getPlayerName(1));
    }

    @Test
    void TestGetPlayerNameInvalidsFirst() {
        String userInput =
                """
                        
                        Vin, heir to the Survivor aka Valette Renoux
                        Vin
                        """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        assertEquals("Vin",GameInitializer.getPlayerName(1));
    }

    @Test
    void TestGetWinningPoints()
    {
        String userInput =
                """
                        -5
                        IXVV
                        4000
                        """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        assertEquals(4000,GameInitializer.getWinningScore());
    }
}









