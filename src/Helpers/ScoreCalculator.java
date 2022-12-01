package Helpers;


import Cards.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class ScoreCalculator {

    public static int calculateScore(List<Integer> selectedDice) {
        Collections.sort(selectedDice);
        List<Integer> diceAmounts = Arrays.asList(Collections.frequency(selectedDice, 1),
                Collections.frequency(selectedDice, 2), Collections.frequency(selectedDice, 3),
                Collections.frequency(selectedDice, 4), Collections.frequency(selectedDice, 5),
                Collections.frequency(selectedDice, 6)
        );
        int score = 0;
        for (int i = 0; i < diceAmounts.size(); i++) {
            int die = i+1;
            int occurence = diceAmounts.get(i);
            if (occurence < 3) {
                if (die == 1) {
                    score += 100 * occurence;
                } else {
                    score += 50 * occurence;
                }
            } else if (occurence == 3) {
                if (die == 1) {
                    score += 1000;
                } else {
                    score += 100 * die;
                }
            } else if (occurence < 6) {
                occurence -= 3;
                if (die == 1) {
                    score += 100 * occurence + 1000;
                } else {
                    score += 50 * occurence + 500;
                }
            } else {
                if (die == 1) {
                    score += 2000;
                } else {
                    score += 200 * die;
                }
            }
        }
        return score;
    }
}

