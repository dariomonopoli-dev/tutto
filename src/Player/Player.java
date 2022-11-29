package Player;

import java.util.Scanner;

import static Helpers.InputValidator.checkDieIndex;

public class Player implements Comparable<Player> {
    private final String playerName;
    private int playerScore;

    public Player (String name) {
        playerName = name;
        playerScore = 0;
    }

    public String getPlayerName () {
        return playerName;
    }
    public int getPlayerScore () {
        return playerScore;
    }
    public void updatePlayerScore (int additionalScore) {
        if (additionalScore <= 0) throw new IllegalArgumentException("Score must be positive!");
        playerScore += additionalScore;
    }

    public void subtractPlayerScore(int additionalScore) {
        if (additionalScore != 1000) throw new IllegalArgumentException("You can only subtract 1000 points!");
        playerScore -= additionalScore;
    }

    Scanner input = new Scanner(System.in);
    public boolean getChoiceContinueRoll () {
        System.out.println(playerName + ", do you want to roll the dice (enter R) or end your turn (enter E)?");
        String answer = input.nextLine();
        while (!answer.equals("R") && !answer.equals("E")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'R' to roll the dice(s) or 'E' if you wish to end your turn.");
            answer = input.nextLine();
        }
        return answer.equals("R");
    }

    public boolean getChoiceAnotherRound () {
        System.out.println(playerName + ", do you want to start another round (enter Y) or end your turn (enter N)?");
        String answer = input.nextLine();
        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'Y' to start another round or 'N' if you wish to end your turn.");
            answer = input.nextLine();
        }
        return answer.equals("Y");
    }

    public boolean getChoiceDisplayScores () {
        System.out.println(playerName + ", do you want to start the round (enter R) or display the scores (enter D)?");
        String answer = input.nextLine();
        while (!answer.equals("R") && !answer.equals("D")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'R' to start the round or 'D' if you wish to display the scores.");
            answer = input.nextLine();
        }
        return answer.equals("D");
    }

    public String getChoiceDice (int activeDice) {
        System.out.println(playerName + " choose at least one valid die or " +
                "triplet by entering the index (e.g. 2 or 2,3,4):");
        String answer = input.nextLine();
        while (answer.length() == 0) {
            System.out.println("Invalid input =(");
            System.out.println(playerName + " choose at least one valid die or " +
                    "triplet by entering the index (e.g. 2 or 2,3,4):");
            answer = input.nextLine();
        }
        checkDieIndex(answer, activeDice);
        return answer;
    }

    public void getAnotherRoll () {
        System.out.println(playerName + ", enter R to roll your dice again:");
        String answer = input.nextLine();
        while (!answer.equals("R")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'R' to roll the dice.");
            answer = input.nextLine();
        }
    }

    @Override
    public int compareTo(Player player) {
        return playerName.compareToIgnoreCase(player.getPlayerName());
    }

}
