package Helpers;


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
            int occurrence = diceAmounts.get(i);
            if (occurrence < 3) {
                if (die == 1) {
                    score += 100 * occurrence;
                } else {
                    score += 50 * occurrence;
                }
            } else if (occurrence == 3) {
                if (die == 1) {
                    score += 1000;
                } else {
                    score += 100 * die;
                }
            } else if (occurrence < 6) {
                occurrence -= 3;
                if (die == 1) {
                    score += 100 * occurrence + 1000;
                } else {
                    score += 50 * occurrence + 500;
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

