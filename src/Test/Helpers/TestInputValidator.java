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


class TestInputValidator extends InputValidator {
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
    void TestHasValidIndexCorrectInput() {
        String inputAnswer = "1,2";
        int activeDice = 2;
        assertTrue(hasValidIndex(inputAnswer, activeDice));
    }
    @Test
    void TestHasValidIndexOutOfBound() {
        String inputAnswer = "6";
        int activeDice = 2;
        assertFalse(hasValidIndex(inputAnswer, activeDice));
    }

    @Test
    void TestHasValidIndexWrongStringFormat() {
        String inputAnswer = "6,3,2";
        int activeDice = 4;
        assertFalse(hasValidIndex(inputAnswer, activeDice));
    }

    @Test
    void TestHasValidIndexTextInput() {
        String inputAnswer = "abcdef";
        int activeDice = 4;
        assertFalse(hasValidIndex(inputAnswer, activeDice));
    }

    @Test
    void TestCheckChoiceValidityAtFirstWrongInput() {
        String userInput = """
                        1,6
                        """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);

        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(1,3,3,4,4,5));
        final List<Integer> expected = Arrays.asList(1,5);
        List<Integer> selectedDice = checkChoiceValidity("1,5", rolledDice);
        assertTrue(expected.size() == selectedDice.size() && expected.containsAll(selectedDice) && selectedDice.containsAll(expected));
    }

    @Test
    void TestCheckChoiceValidityCorrectInput() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(1,3,3,4,4,5));
        final List<Integer> expected = Arrays.asList(1,5);
        List<Integer> selectedDice = checkChoiceValidity("1,6", rolledDice);
        assertTrue(expected.size() == selectedDice.size() && expected.containsAll(selectedDice) && selectedDice.containsAll(expected));
    }

    @Test
    void TestCheckChoiceValidityStraightCorrectAnswer() {
        String answer = "1,2";
        List<Integer> rolledDice = new ArrayList<>(Arrays.asList(2,3));
        List<Integer> diceSetAside = new ArrayList<>(Arrays.asList(5,4,1,6));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2,3));
        assertEquals(expected, checkChoiceValidityStraight(answer, rolledDice, diceSetAside));
    }

    @Test
    void TestCheckChoiceValidityStraightWrongAnswer() {
        String userInput = """
                        1,2
                        """;
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);

        String initialAnswer = "3";
        List<Integer> rolledDice = new ArrayList<>(Arrays.asList(2,3,1));
        List<Integer> diceSetAside = new ArrayList<>(Arrays.asList(5,4,1));
        List<Integer> expected = new ArrayList<>(Arrays.asList(2,3));
        assertEquals(expected, checkChoiceValidityStraight(initialAnswer, rolledDice, diceSetAside));
    }

    @Test
    void TestCheckIsValidRollCorrect() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(2,3,4,1,6,5));
        assertTrue(checkIsValidRoll(rolledDice));
    }

    @Test
    void TestCheckIsValidRollFalse() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(2,3,4,2,6,6));
        assertFalse(checkIsValidRoll(rolledDice));
    }

    @Test
    void TestCheckIsValidRollStraightCorrect() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(2,3,4,1));
        final List<Integer> setAside =  new ArrayList<>(Arrays.asList(2,3));
        assertTrue(checkIsValidRollStraight(rolledDice, setAside));
    }

    @Test
    void TestCheckIsValidRollStraightWrong() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(2,3,2,3));
        final List<Integer> setAside =  new ArrayList<>(Arrays.asList(2,3));
        assertFalse(checkIsValidRollStraight(rolledDice, setAside));
    }

    @Test
    void TestIsValidChoiceCorrect() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(3,3,3,1));
        final List<String> answerList =  new ArrayList<>(Arrays.asList("1","2","3","4"));
        assertTrue(isValidChoice(rolledDice, answerList));
    }

    @Test
    void TestIsValidChoiceWrong() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(3,2,3,1));
        final List<String> answerList =  new ArrayList<>(Arrays.asList("1","2","3","4"));
        assertFalse(isValidChoice(rolledDice, answerList));
    }

    @Test
    void TestIsValidChoiceStraightCorrect() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(1,2,3));
        final List<Integer> diceSetAside =  new ArrayList<>(Arrays.asList(6,5,4));
        final List<String> answerList =  new ArrayList<>(Arrays.asList("1","2","3"));
        assertTrue(isValidChoiceStraight(answerList ,rolledDice, diceSetAside));
    }

    @Test
    void TestIsValidChoiceStraightAlreadySetAside() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(1,2,4));
        final List<Integer> diceSetAside =  new ArrayList<>(Arrays.asList(6,5,4));
        final List<String> answerList =  new ArrayList<>(Arrays.asList("1","2","3"));
        assertFalse(isValidChoiceStraight(answerList ,rolledDice, diceSetAside));
    }

    @Test
    void TestIsValidChoiceStraightSameDiceChosen() {
        final List<Integer> rolledDice =  new ArrayList<>(Arrays.asList(1,1,3));
        final List<Integer> diceSetAside =  new ArrayList<>(Arrays.asList(6,5,4));
        final List<String> answerList =  new ArrayList<>(Arrays.asList("1","2","3"));
        assertFalse(isValidChoiceStraight(answerList ,rolledDice, diceSetAside));
    }

    @Test
    void TestHasTripletCorrect() {
        List<Integer> rolledDice = new ArrayList<>(Arrays.asList(5,5,5,4,3,2));
        assertTrue(hasTriplet(rolledDice, 0));
    }

    @Test
    void TestHasTripletWrong() {
        List<Integer> rolledDice = new ArrayList<>(Arrays.asList(5,5,3,4,3,2));
        assertFalse(hasTriplet(rolledDice, 3));
    }

    @Test
    void TestHasSingleCorrect() {
        List<Integer> rolledDice = new ArrayList<>(Arrays.asList(2,5,6,4,4));
        assertTrue(hasSingle(rolledDice, 1));
    }

    @Test
    void TestHasSingleWrong() {
        List<Integer> rolledDice = new ArrayList<>(Arrays.asList(2,2,6,4,4));
        assertFalse(hasSingle(rolledDice, 0));
    }

}