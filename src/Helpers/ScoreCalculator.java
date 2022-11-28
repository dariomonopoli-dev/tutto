package Helpers;


import Cards.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class ScoreCalculator {
    private static int tempScore = 0;
    private static int result = 0;
    private static int validDices = 0;
    private static int numberOfTuttos = 0;
    private static List<Integer> tempArr = new ArrayList<>(6);

    private static boolean checkZeroInArray(List<Integer> tempArr) {
        return tempArr.contains(0);

    }

    private static int calculateNormal(List <Integer> dices, AbstractCard card) {

        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i) != 0) {
                if ((Collections.frequency(dices, dices.get(i)) >= 3)) {
                    tempScore += dices.get(i) == 1 ? dices.get(i) * 1000 : dices.get(i) * 100;
                    validDices += 3;
                } else if (dices.get(i) == 1) {
                    tempScore += 100;
                    validDices += 1;
                } else if (dices.get(i) == 5) {
                    tempScore += 50;
                    validDices += 1;
                }
            }
        }
        if (validDices == dices.size()) {
            numberOfTuttos += 1;
            if (card instanceof CardCloverleaf) {
                List <Integer> new_dices = DiceRoller.rollDice(6);
                calculateScore(new_dices, card);
            }
            return tempScore;
        } else {
            if (card instanceof CardFireworks) {
                return tempScore;
            } else if (card instanceof CardBonus || card instanceof CardCloverleaf || card instanceof CardX2) {

                tempScore = 0;
                return tempScore;
            }
        }
        return tempScore;
    }
    private static int calculateStraight(List <Integer> dices) {
        List<Integer> tempDices;
        boolean checkNewDice;
        int index = 0;
        for (int i = 0; i < dices.size(); i++) {
            checkNewDice = false;
            tempArr.add(i, 0); //to initialize tempArr
            if (dices.get(i) != 0) {

                if (!tempArr.contains(dices.get(i))) {
                    tempArr.set(index, dices.get(i));
                    checkNewDice = true;
                    index++;
                }

                while ((tempArr.stream().distinct().toList().size() != 6) && checkZeroInArray(tempArr)) {

                    if (checkNewDice) {
                        tempDices = DiceRoller.rollDice(6 - (tempArr.stream().distinct()).toList().size());
                        calculateStraight(tempDices);

                    } else if ((tempArr.stream().distinct()).toList().size() == 6 & checkZeroInArray(tempArr)) {
                        return 2000;
                    } else {
                        return 0;
                    }
                }
                i++;
            }
        }
        return 0;
    }



    public static int calculateScore(List<Integer> dices, AbstractCard card) {
        if (card instanceof CardCloverleaf) {
            if (numberOfTuttos == 2) {
                System.out.println("Player X won the game!");

            }
            else {
                return calculateNormal(dices, card);
            }
        }
        if (card instanceof CardBonus) {
            CardBonus bonusCard = (CardBonus) card;
            result = calculateNormal(dices, card);
            if (result != 0) {
                result = calculateNormal(dices, card) + bonusCard.getBonus();
            }
            return result;
        }
        else if (card instanceof CardX2) {
            result = calculateNormal(dices, card);
            if (result != 0) {
                result = 2 * calculateNormal(dices, card);
            }
            return result;
        }
        else if (card instanceof CardStraight) {
            result = calculateStraight(dices);
            return result;
        }

        else if (card instanceof CardFireworks) {
            result = calculateNormal(dices, card);
            return result;

        }

        return result;
    }
}

