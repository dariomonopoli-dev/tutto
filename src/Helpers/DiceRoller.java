package Helpers;

import java.util.*;

import static Helpers.InputValidator.hasSingle;
import static Helpers.InputValidator.hasTriplet;

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

        public static List<Integer> getAllValidDice(List<Integer> rolledDice) {
            List<Integer> diceSetAside = new ArrayList<>();
            for (int i = 0; i < rolledDice.size(); i++) {
                if (rolledDice.size()-i > 2 && isConcatenated(rolledDice, i)) {
                    if(hasTriplet(rolledDice, i)) {
                        diceSetAside.add(rolledDice.get(i)+111);
                    }
                    i += 2;
                } else {
                    if (hasSingle(rolledDice, i)) {
                        diceSetAside.add(rolledDice.get(i));
                    }
                }
            }
            return diceSetAside;
        }

        private static boolean isConcatenated (List<Integer> rolledDice, int index) {
            return (rolledDice.get(index) == rolledDice.get(index+1) && rolledDice.get(index) == rolledDice.get(index+2));
        }

        public static void main (String[] args) {
            List<Integer> rolledDice = Arrays.asList(1, 1, 1, 2, 2, 2);
            List<Integer> allValidDice = getAllValidDice(rolledDice);
            for (int die : allValidDice) {
                System.out.println(die);
            }
        }
}


