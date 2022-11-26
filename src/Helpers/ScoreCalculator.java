package Helpers;


import Cards.AbstractCard;

import java.util.ArrayList;
import java.util.Collections;
public class ScoreCalculator {
    private int tempScore = 0;
    private int result = 0;
    private int validDices = 0;
    private int numberOfTuttos = 0;
    private ArrayList<Integer> tempArr = new ArrayList<>(6);

    private boolean checkZeroInArray(ArrayList<Integer> tempArr) {
        return tempArr.contains(0);

    }

    private int calculateNormal(ArrayList <Integer> dices, String cardName) {

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
            if (cardName.equals("Cloverleaf")) {
                DiceRoller newRoll = new DiceRoller();
                newRoll.rollDices(6);
                newRoll.rollDices(6);
                ArrayList <Integer> new_dices = newRoll.getRolledDices();
                calculateScore(new_dices, AbstractCard.getCloverleaf());
            }
            return tempScore;
        } else {
            if (cardName.equals("Fireworks")) {
                return tempScore;
            } else if (cardName.equals("Bonus") || cardName.equals("Cloverleaf") || cardName.equals("X2")) {

                tempScore = 0;
                return tempScore;
            }
        }
        return tempScore;
    }
    private int calculateStraight(ArrayList <Integer> dices) {
        ArrayList<Integer> tempDices;
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
                        DiceRoller newRoll = new DiceRoller();
                        newRoll.rollDices(6 - (tempArr.stream().distinct()).toList().size());
                        tempDices = newRoll.getRolledDices();
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



    public int calculateScore(ArrayList<Integer> dices, AbstractCard card) {
        if (card.getCardName().equals("Cloverleaf")) {
            if (numberOfTuttos == 2) {
                System.out.println("Player X won the game!");

            }
            else {
                return calculateNormal(dices, card.getCardName());
            }
        }
        if (card.getCardName().startsWith("Bonus")) {
            result = calculateNormal(dices, card.getCardName());
            if (result != 0) {
                result = calculateNormal(dices, card.getCardName()) + card.bonus;
            }
            return result;
        }
        else if (card.getCardName().equals("X2")) {
            result = calculateNormal(dices, card.getCardName());
            if (result != 0) {
                result = 2 * calculateNormal(dices, card.getCardName());
            }
            return result;
        }
        else if (card.getCardName().equals("Straight")) {
            result = calculateStraight(dices);
            return result;
        }

        else if (card.getCardName().equals("Fireworks")) {
            result = calculateNormal(dices, card.getCardName());
            return result;

        }

        return result;
    }
}

