package Helpers;

import Player.Player;

import java.util.*;

public class InputValidator {

    public static boolean hasValidIndex (String answer,int activeDice) {
        List<String> possibleAnswers = Arrays.asList(
                "1","2","3","4","5","6",
                "1,2","1,3","1,4","1,5","1,6",
                "2,3","2,4","2,5","2,6",
                "3,4","3,5","3,6",
                "4,5","4,6",
                "5,6",
                "1,2,3","1,2,4","1,2,5","1,2,6","1,3,4","1,3,5","1,3,6","1,4,5","1,4,6","1,5,6",
                "2,3,4","2,3,5","2,3,6","2,4,5","2,4,6","2,5,6",
                "3,4,5","3,4,6","3,5,6",
                "4,5,6",
                "1,2,3,4","1,2,3,5","1,2,3,6","1,2,4,5","1,2,4,6","1,2,5,6",
                "1,3,4,5","1,3,4,6","1,3,5,6",
                "1,4,5,6",
                "2,3,4,5","2,3,4,6","2,3,5,6",
                "2,4,5,6",
                "3,4,5,6",
                "1,2,3,4,5","1,2,3,4,6","1,2,3,5,6","1,2,4,5,6",
                "1,3,4,5,6",
                "2,3,4,5,6",
                "1,2,3,4,5,6"
        );
        List<String> answerList = getStringList(answer);
        int lastIndex = activeDice+1;
        try {
            lastIndex = Integer.parseInt(answerList.get(answerList.size() - 1));
        }
        catch (NumberFormatException e) {
            lastIndex = activeDice+1;
        }
        return (possibleAnswers.contains(answer) && lastIndex <= activeDice);
    }

    /**
     * @post method ensures the selected die-indexes are valid options
     * and returns a list where each choice corresponds to one item
     */
    public static List<Integer> checkChoiceValidity (String answer, List<Integer> rolledDice, Player activePlayer) {
        List<String> answerList = getStringList(answer);
        boolean validInput = isValidChoice(rolledDice, answerList);
        while (!validInput) {
            answer = activePlayer.getChoiceDice(rolledDice.size());
            answerList = getStringList(answer);
            // go through every choice
            validInput = isValidChoice(rolledDice, answerList);
        }
        return getSelectedDice(answerList, rolledDice);
    }

    /**
     * @post method ensures the selected die-indexes are valid options
     * for a straight and returns a list where each choice corresponds
     * to one item
     */
    public static List<Integer> checkChoiceValidityStraight (String answer, List<Integer> rolledDice, List<Integer> diceSetAside, Player activePlayer) {
        List<String> answerList = getStringList(answer);
        boolean validInput = isValidChoiceStraight(answerList, rolledDice, diceSetAside);
        while (!validInput) {
            answer = activePlayer.getChoiceDice(rolledDice.size());
            answerList = getStringList(answer);
            validInput = isValidChoiceStraight(answerList, rolledDice, diceSetAside);
        }
        return getSelectedDice(answerList, rolledDice);
    }

    public static boolean checkIsValidRoll (List<Integer> rolledDice) {
        int occurrenceOnes = Collections.frequency(rolledDice, 1);
        int occurrenceTwos = Collections.frequency(rolledDice, 2);
        int occurrenceThrees = Collections.frequency(rolledDice, 3);
        int occurrenceFours = Collections.frequency(rolledDice, 4);
        int occurrenceFives = Collections.frequency(rolledDice, 5);
        int occurrenceSix = Collections.frequency(rolledDice, 6);

        return (occurrenceOnes > 0 || occurrenceTwos > 2 || occurrenceThrees > 2 ||
                occurrenceFours > 2 || occurrenceFives > 0 || occurrenceSix > 2);
    }

    public static boolean checkIsValidRollStraight (List<Integer> rolledDice, List<Integer> diceSetAside) {
        for (Integer dieValue : rolledDice) {
            if (!diceSetAside.contains(dieValue)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidChoice (List<Integer> rolledDice, List<String> answerList) {
        List<Integer> chosenDice = getSelectedDice(answerList, rolledDice);
        for (int die : chosenDice) {
            int amountOfDice = Collections.frequency(chosenDice, die);
            if (amountOfDice % 3 != 0) {
                if (die != 1 && die != 5) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidChoiceStraight(List<String> answerList, List<Integer> rolledDice, List<Integer> diceSetAsideOrig) {
        List<Integer> diceSetAsideCopy = new ArrayList<>(diceSetAsideOrig);
        for (String s : answerList) {
            int index = Integer.parseInt(s) - 1;
            if (diceSetAsideCopy.contains(rolledDice.get(index))) {
                return false;
            }
            diceSetAsideCopy.add(rolledDice.get(index));
        }
        return true;
    }

    public static boolean hasTriplet (List<Integer> rolledDice, int currentIndex) {
        int indexValue = rolledDice.get(currentIndex);
        int nextIndexValue = rolledDice.get(currentIndex+1);
        int nextButOneIndexValue = rolledDice.get(currentIndex+2);
        return (indexValue == nextIndexValue && indexValue == nextButOneIndexValue);
    }

    public static boolean hasSingle (List<Integer> rolledDice, int currentIndex) {
        List<Integer> singles = Arrays.asList(1,5);
        int currentChoice = rolledDice.get(currentIndex);
        return singles.contains(currentChoice);
    }

    private static List<String> getStringList(String answer) {
        return (answer.contains(",")) ?
                Arrays.asList(answer.split(",")) :
                Collections.singletonList(answer);
    }

    private static List<Integer> getSelectedDice(List<String> answerList, List<Integer> rolledDice) {
        List<Integer> choicesList = new ArrayList<>();
        for (String s: answerList) {
            int choice = Integer.parseInt(s)-1;
            choicesList.add(rolledDice.get(choice));
        }
        return choicesList;
    }
}
