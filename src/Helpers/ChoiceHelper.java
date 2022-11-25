package Helpers;

import java.util.*;

public class ChoiceHelper {

    private static Scanner input = new Scanner(System.in);

    private static String getNewIndexChoice() {
        System.out.println("Invalid input =(");
        System.out.println("Please enter indexes in the correct format (e.g. 2 or 2,3,4):");
        return input.nextLine();
    }

    private static List<String> getAnswerList(String answer) {
        return (answer.length() > 1) ?
                Arrays.asList(answer.split(",")) :
                Collections.singletonList(answer);
    }

    public static void checkAnswerRandD (String answer) {
        while (!answer.equals("R") && !answer.equals("D")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'R' to roll the dice or 'D' if you wish the scores to be displayed:");
            answer = input.nextLine();
        }
    }

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
        List<String> answerList = (answer.length() > 1) ?
                Arrays.asList(answer.split(",")) :
                Collections.singletonList(answer);
        while (!possibleAnswers.contains(answer) || answerList.size() > activeDice) {
            answer = getNewIndexChoice();
            answerList = (answer.length() > 1) ?
                    Arrays.asList(answer.split(",")) :
                    Collections.singletonList(answer);
        }
    }

    /**
     * @post method ensures the selected die-indexes are valid options
     */
    public static List<String> checkChoiceValidity(String answer, List<Integer> rolledDice) {
        List<String> answerList = getAnswerList(answer);
        boolean validInput = isValidInput(rolledDice, answerList);
        while (!validInput) {
            answer = getNewIndexChoice();
            answerList = getAnswerList(answer);
            // go through every choice
            validInput = isValidInput(rolledDice, answerList);
        }
        return getChoicesList(rolledDice, answerList);
    }

    private static boolean isValidInput(List<Integer> rolledDice, List<String> answerList) {
        boolean validInput = false;
        for (int i = 0; i < answerList.size(); i++) {
            int choice = Integer.parseInt(answerList.get(i))-1;
            // check whether current index is concatenated with the next 2
            if (answerList.size()-i > 2 && isConcatenated(answerList, i)) {
                validInput = checkTriplets(rolledDice, choice);
                i += 2;
            } else {
                validInput = checkSingles(rolledDice, choice);
            }
        }
        return validInput;
    }

    private static boolean isConcatenated(List<String> answerList, int currentIndex) {
        int index = Integer.parseInt(answerList.get(currentIndex));
        int nextIndex = Integer.parseInt(answerList.get(currentIndex+1));
        int nextButOneIndex = Integer.parseInt(answerList.get(currentIndex+2));
        return (index+1 == nextIndex && index+2 == nextButOneIndex);
    }

    private static boolean checkTriplets(List<Integer> rolledDice, int currentIndex) {
        int indexValue = rolledDice.get(currentIndex);
        int nextIndexValue = rolledDice.get(currentIndex+1);
        int nextButOneIndexValue = rolledDice.get(currentIndex+1);
        return (indexValue == nextIndexValue && indexValue == nextButOneIndexValue);
    }

    private static boolean checkSingles(List<Integer> rolledDice, int currentIndex) {
        List<String> singles = Arrays.asList("1","5");
        int currentChoice = rolledDice.get(currentIndex);
        return singles.contains(Integer.toString(currentChoice));
    }

    private static List<String> getChoicesList(List<Integer> rolledDice, List<String> answerList) {
        List<String> choicesList = new ArrayList<>();
        for (int i = 0; i < answerList.size(); i++) {
            int choice = Integer.parseInt(answerList.get(i))-1;
            // check whether current index is concatenated with the next 2
            if (answerList.size()-i > 2 && isConcatenated(answerList, i)) {
                String placeholder = Integer.toString(rolledDice.get(choice));
                choicesList.add(placeholder.repeat(3));
                i += 2;
            } else {
                String placeholder = Integer.toString(rolledDice.get(choice));
                choicesList.add(placeholder);
            }
        }
        return choicesList;
    }

}
