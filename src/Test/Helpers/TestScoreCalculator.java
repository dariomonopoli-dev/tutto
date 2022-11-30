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
        List<Integer> someDices = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        assertEquals(150, sc.calculateScore(someDices));
    }


    @Test
    void calculateTriplet() {
        final ScoreCalculator sc = new ScoreCalculator();
        List<Integer> someDices = new ArrayList<Integer>(Arrays.asList(111,666));
        assertEquals(1600, sc.calculateScore(someDices));

    }
}