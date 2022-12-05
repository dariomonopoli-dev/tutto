package Test.Gamestate;

import Gamestate.Displayer;
import Gamestate.Gameplay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestGameplay extends Gameplay {

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
    void TestWaitForEnter() {
        String userInput = "\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);

        waitForEnter("Test message with a lot of symbols!#*Ü*");

        String expectedOutput1 = "Test message with a lot of symbols!#*Ü*";

        assertTrue(outputStreamCaptor.toString().contains(expectedOutput1));
    }
}
