package Test.Helpers;

import org.junit.jupiter.api.Test;
import Helpers.DiceRoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestDiceRoller {

    @Test
    void TestNumberOfRolledDices() {
        final DiceRoller diceRollerTest = new DiceRoller();
        List<Integer> rolledDicesTest = diceRollerTest.rollDice(6);
        assertEquals(6, rolledDicesTest.size());

    }

    @Test
    void TestZeroDices() {
        final DiceRoller diceRollerTest2 = new DiceRoller();
        assertThrows(IllegalArgumentException.class, () -> diceRollerTest2.rollDice(0), "Insert a number of dices between 1 and 6!");

    }

    @Test
    void TestMoreThanSixDices() {
        final DiceRoller diceRollerTest2 = new DiceRoller();
        assertThrows(IllegalArgumentException.class, () -> diceRollerTest2.rollDice(7), "Insert a number of dices between 1 and 6!");

    }


    @Test
    void isConcatenated() {
        DiceRoller dr = new DiceRoller();
        List<Integer> rolledDice = new ArrayList<>();
        rolledDice.add(0, 1);
        rolledDice.add(1, 1);
        rolledDice.add(2, 1);
        assertEquals(true, dr.isConcatenated(rolledDice, 0));
    }

    @Test
    void isConcatenated2() {
        DiceRoller dr = new DiceRoller();
        List<Integer> rolledDice = new ArrayList<>();
        rolledDice.add(0, 1);
        rolledDice.add(1, 2);
        rolledDice.add(2, 2);
        assertEquals(false, dr.isConcatenated(rolledDice, 0));
    }

    @Test
    void getAllValidDice() {
        final DiceRoller dr = new DiceRoller();
        List<Integer> diceRoll = new ArrayList<Integer>(Arrays.asList(1,1,2,3,4,5));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,1,5));
        List<Integer> diceRoll2 = new ArrayList<Integer>(Arrays.asList(1,1,1,3,4,5));
        List<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(1,1,1,5));

        assertEquals(expected, dr.getAllValidDice(diceRoll));
        assertEquals(expected2, dr.getAllValidDice(diceRoll2));
    }
}



