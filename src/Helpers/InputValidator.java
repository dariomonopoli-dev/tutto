package Helpers;

import java.util.*;

public class InputValidator {

    private static Scanner input = new Scanner(System.in);

    /**
     * @post method checks whether the input if of the correct form and
     *  a feasible choice (i.e. not more indexes than dice)
     */
    public static void checkDieIndex(String answer, int activeDice) {
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
        while (!possibleAnswers.contains(answer) || answerList.size() > activeDice) {
            answer = getNewIndexChoice();
            answerList = getStringList(answer);
        }
    }

    /**
     * @post method ensures the selected die-indexes are valid options
     * and returns a list where each choice corresponds to one item
     */
    public static List<Integer> checkChoiceValidity (String answer, List<Integer> rolledDice) {
        List<String> answerList = getStringList(answer);
        boolean validInput = isValidChoice(rolledDice, answerList);
        while (!validInput) {
            answer = getNewIndexChoice();
            answerList = getStringList(answer);
            // go through every choice
            validInput = isValidChoice(rolledDice, answerList);
        }
        return getIntegerList(answerList, rolledDice);
    }

    /**
     * @post method ensures the selected die-indexes are valid options
     * for a straight and returns a list where each choice corresponds
     * to one item
     */
    public static List<Integer> checkChoiceValidityStraight (String answer, List<Integer> rolledDice, List<Integer> diceSetAside) {
        List<String> answerList = getStringList(answer);
        if (diceSetAside == null) {
            return getIntegerList(answerList, rolledDice);
        }
        while (!isValidChoiceStraight(answerList, rolledDice, diceSetAside)) {
            answer = getNewIndexChoice();
            answerList = getStringList(answer);
        }
        return getIntegerList(answerList, rolledDice);
    }

    /**
     * @post check whether a roll has valid dice to choose
     */
    public static boolean checkIsValidRoll (List<Integer> rolledDice) {
        int occurrenceOnes = 0;
        int occurrenceTwos = 0;
        int occurrenceThrees = 0;
        int occurrenceFours = 0;
        int occurrenceFives = 0;
        int occurrenceSix = 0;
        
        for (int die : rolledDice) {
            if (die == 1) {
                occurrenceOnes++;
            } else if (die == 2) {
                occurrenceTwos++;
            } else if (die == 3) {
                occurrenceThrees++;
            } else if (die == 4) {
                occurrenceFours++;
            } else if (die == 5) {
                occurrenceFives++;
            } else {
                occurrenceSix++;
            }
        }
        return (occurrenceOnes > 0 || occurrenceTwos > 2 || occurrenceThrees > 2 ||
                occurrenceFours > 2 || occurrenceFives > 0 || occurrenceSix > 2);
    }

    /**
     * @post check whether a roll has valid dice for a straight to choose
     */
    public static boolean checkIsValidRollStraight (List<Integer> rolledDice, List<Integer> diceSetAside) {
        for (int i = 0; i < rolledDice.size(); i++) {
            if (!diceSetAside.contains(rolledDice.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidChoice (List<Integer> rolledDice, List<String> answerList) {
        boolean validInput = false;
        for (int i = 0; i < answerList.size(); i++) {
            int choice = Integer.parseInt(answerList.get(i))-1;
            // check whether current index is concatenated with the next 2
            if (answerList.size()-i > 2 && isConcatenated(answerList, i)) {
                validInput = hasTriplet(rolledDice, choice);
                i += 2;
            } else {
                validInput = hasSingle(rolledDice, choice);
            }
        }
        return validInput;
    }

    private static boolean isValidChoiceStraight (List<String> answerList, List<Integer> rolledDice, List<Integer> diceSetAside) {
        for (int i = 0; i < answerList.size(); i++) {
            int index = Integer.parseInt(answerList.get(i))-1;
            if (diceSetAside.contains(rolledDice.get(index))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isConcatenated(List<String> answerList, int currentIndex) {
        int index = Integer.parseInt(answerList.get(currentIndex));
        int nextIndex = Integer.parseInt(answerList.get(currentIndex+1));
        int nextButOneIndex = Integer.parseInt(answerList.get(currentIndex+2));
        return (index+1 == nextIndex && index+2 == nextButOneIndex);
    }

    public static boolean hasTriplet (List<Integer> rolledDice, int currentIndex) {
        int indexValue = rolledDice.get(currentIndex);
        int nextIndexValue = rolledDice.get(currentIndex+1);
        int nextButOneIndexValue = rolledDice.get(currentIndex+1);
        return (indexValue == nextIndexValue && indexValue == nextButOneIndexValue);
    }

    public static boolean hasSingle (List<Integer> rolledDice, int currentIndex) {
        List<String> singles = Arrays.asList("1","5");
        int currentChoice = rolledDice.get(currentIndex);
        return singles.contains(Integer.toString(currentChoice));
    }

    private static List<String> getStringList(String answer) {
        return (answer.length() > 1) ?
                Arrays.asList(answer.split(",")) :
                Collections.singletonList(answer);
    }

    private static List<Integer> getIntegerList(List<String> answerList, List<Integer> rolledDice) {
        List<Integer> choicesList = new ArrayList<>();
        for (int i = 0; i < answerList.size(); i++) {
            int choice = Integer.parseInt(answerList.get(i))-1;
            // check whether current index is concatenated with the next 2
            if (answerList.size()-i > 2 && isConcatenated(answerList, i)) {
                choicesList.add(rolledDice.get(choice)*111);
                i += 2;
            } else {
                choicesList.add(rolledDice.get(choice));
            }
        }
        return choicesList;
    }

    private static String getNewIndexChoice() {
        System.out.println("Invalid input =(");
        System.out.println("Please enter indexes in the correct format (e.g. 2 or 2,3,4):");
        return input.nextLine();
    }
}
