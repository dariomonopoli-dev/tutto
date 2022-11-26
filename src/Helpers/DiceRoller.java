package Helpers;

import java.util.*;
public class DiceRoller {
        private static Random ran = new Random();

        public static List<Integer> rollDice(int numberOfDice) {
            List<Integer> rolledDice = new ArrayList<Integer>(numberOfDice);
            if (!(numberOfDice >=1 && numberOfDice <=6)) {
                throw new IllegalArgumentException("Enter a number of dices between 1 and 6!");
            }
            for (int i = 0; i < numberOfDice; i++) {
                rolledDice.set(i, ran.nextInt(6) + 1);
            }
            return rolledDice;
        }
    }


