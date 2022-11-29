package Helpers;


import Cards.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class ScoreCalculator {

    public static int calculateScore(List<Integer> selectedDice) {
        int score = 0;
        for (int die : selectedDice) {
            if (die > 6) {
                int placeholderDie = die / 111;
                if (placeholderDie == 1) {
                    score += 1000;
                } else {
                    score += placeholderDie * 100; }
            } else if (die == 1) {
                score += 100;
            } else {
                score += 50;
            }
        }
        return score;
    }
}

