package Test.Helpers;

import Helpers.ScoreCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestScoreCalculator {

    @Test
    void calculateScore() {
        final ScoreCalculator sc = new ScoreCalculator();
        List<Integer> someDie = new ArrayList<Integer>(Arrays.asList(1));
        assertEquals(100, sc.calculateScore(someDie));
        List<Integer> fourFives = new ArrayList<Integer>(Arrays.asList(5,5,5,5));
        assertEquals(550, sc.calculateScore(fourFives));
        List<Integer> sixFives = new ArrayList<Integer>(Arrays.asList(5,5,5,5,5,5));
        assertEquals(1000, sc.calculateScore(sixFives));
        List<Integer> fiveOnes = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1));
        assertEquals(1200, sc.calculateScore(fiveOnes));
        List<Integer> sixOnes = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1));
        assertEquals(2000, sc.calculateScore(sixOnes));


    }


    @Test
    void calculateTriplet() {
        final ScoreCalculator sc = new ScoreCalculator();
        List<Integer> someDices = new ArrayList<Integer>(Arrays.asList(1,1,1,6,6,6));
        assertEquals(1600, sc.calculateScore(someDices));
        List<Integer> someOtherDices = new ArrayList<Integer>(Arrays.asList(5,5,5,4,4,4));
        assertEquals(900, sc.calculateScore(someOtherDices));

    }
}