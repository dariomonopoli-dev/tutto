package Test.Helpers;

import Helpers.InputValidator;
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


class TestInputValidator {
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
    void TestCheckChoiceValidity() {
        String userInput = """
                        1,6
                        """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(1,3,3,4,4,5));
        final List<Integer> expected = Arrays.asList(1,5);
        List<Integer> selectedDice = InputValidator.checkChoiceValidity("1,5", rolledDice);
        assertTrue(expected.size() == selectedDice.size() && expected.containsAll(selectedDice) && selectedDice.containsAll(expected));
    }

    @Test
    void TestCheckChoiceValidityStraight() {
        String answer = "2,3";
        List<Integer> rolledDice = new ArrayList<Integer>(Arrays.asList(5,2,3));
        List<Integer> diceSetAside = new ArrayList<Integer>(Arrays.asList(5,4,1,6));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,3));
        assertEquals(expected, InputValidator.checkChoiceValidityStraight(answer, rolledDice, diceSetAside));
    }

    @Test
    void TestCheckIsValidRoll() {
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1,6,5));
        assertEquals(true, InputValidator.checkIsValidRoll(rolledDice));

    }

    @Test
    void TestCheckIsValidRollStraight() {
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1));
        final List<Integer> setAside =  new ArrayList<Integer>(Arrays.asList(2,3));

        assertEquals(true, InputValidator.checkIsValidRollStraight(rolledDice, setAside));
    }

    @Test
    void TestIsValidChoice() {
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1));
        final List<Integer> setAside =  new ArrayList<Integer>(Arrays.asList(1,3));
        assertEquals(true, InputValidator.checkIsValidRollStraight(rolledDice, setAside));


    }

    @Test
    void TestHasTriplet() {
        List<Integer> rolledDice = new ArrayList<Integer>(Arrays.asList(5,5,5,4,3,2));
        assertEquals(true, InputValidator.hasTriplet(rolledDice, 0));

    }

    @Test
    void TestHasSingle() {
        List<Integer> rolledDice = new ArrayList<Integer>(Arrays.asList(2,2,6,4,4));
        assertEquals(false, InputValidator.hasTriplet(rolledDice, 0));
    }

    @Test
    void TestHasValidIndex() {
        String answer1 = "1,2";
        int activeDice = 2;
        assertEquals(true, InputValidator.hasValidIndex(answer1, activeDice));

    }

}