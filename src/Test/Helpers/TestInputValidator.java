package Test.Helpers;

import Helpers.InputValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestInputValidator {

    @Test
    void checkDieIndex() {
    }

    @Test
    void checkChoiceValidity() {
        System.out.println("Input 4,6 to pass this test");
        final InputValidator iv = new InputValidator();
        final String answer = "4,5";
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1,6,5));
        final List<Integer> expected = new ArrayList<>();
        expected.add(0, 1);
        expected.add(1, 5);
        assertEquals(expected, iv.checkChoiceValidity(answer, rolledDice));

    }

    @Test
    void checkChoiceValidityStraight() {
        final InputValidator iv = new InputValidator();
        String answer = "2,3";
        List<Integer> rolledDice = new ArrayList<Integer>(Arrays.asList(5,2,3));
        List<Integer> diceSetAside = new ArrayList<Integer>(Arrays.asList(5,4,1,6));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,3));
        assertEquals(expected, iv.checkChoiceValidityStraight(answer, rolledDice, diceSetAside));
    }

    @Test
    void checkIsValidRoll() {
        final InputValidator iv = new InputValidator();
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1,6,5));
        assertEquals(true, iv.checkIsValidRoll(rolledDice));

    }

    @Test
    void checkIsValidRollStraight() {
        final InputValidator iv = new InputValidator();
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1));
        final List<Integer> setAside =  new ArrayList<Integer>(Arrays.asList(2,3));

        assertEquals(true, iv.checkIsValidRollStraight(rolledDice, setAside));
    }

    @Test
    void isValidChoice() {
        final InputValidator iv = new InputValidator();
        final List<Integer> rolledDice =  new ArrayList<Integer>(Arrays.asList(2,3,4,1));
        final List<Integer> setAside =  new ArrayList<Integer>(Arrays.asList(1,3));
        assertEquals(true, iv.checkIsValidRollStraight(rolledDice, setAside));


    }

    @Test
    void hasTriplet() {
        final InputValidator iv = new InputValidator();
        List<Integer> rolledDice = new ArrayList<Integer>(Arrays.asList(5,5,5,4,3,2));
        assertEquals(true, iv.hasTriplet(rolledDice, 0));

    }

    @Test
    void hasSingle() {
        final InputValidator iv = new InputValidator();
        List<Integer> rolledDice = new ArrayList<Integer>(Arrays.asList(2,2,6,4,4));
        assertEquals(false, iv.hasTriplet(rolledDice, 0));
    }

    @Test
    void hasValidIndex() {
        final InputValidator iv = new InputValidator();
        String answer1 = "1,2";
        int activeDice = 2;
        assertEquals(true, iv.hasValidIndex(answer1, activeDice));

    }

}