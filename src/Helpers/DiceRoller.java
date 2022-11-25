package Helpers;

import java.util.*;
public class DiceRoller {


        private static DiceRoller uniqueInstance = new DiceRoller();
        private Random ran = new Random();
        private ArrayList<Integer> rolledDices = new ArrayList<Integer>(Collections.nCopies(6, 0));


        public void rollDices(int numberOfDices) {
            if (!(numberOfDices >=1 && numberOfDices <=6)) {
                throw new IllegalArgumentException("Insert a number of dices between 1 and 6!");
            }
            for (int i = 0; i < numberOfDices; i++) {
                rolledDices.set(i, ran.nextInt(6) + 1);
            }
            for(int i = numberOfDices; i < 6; i++) {
                rolledDices.set(i, 0);
            }
        }

        public ArrayList<Integer> getRolledDices() {
            return rolledDices;
        }

        public static DiceRoller getInstance() {
            return uniqueInstance;
        }

    }


