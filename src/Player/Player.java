package Player;

import Gamestate.Displayer;

import java.util.Scanner;

import static Helpers.InputValidator.hasValidIndex;

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

    public void increasePlayerScore (int additionalScore) {
        if (additionalScore < 0) throw new IllegalArgumentException("Score must be positive!");
        playerScore += additionalScore;
    }

    public void decreasePlayerScoreBy1000() {
        playerScore -= 1000;
    }

    Scanner input = new Scanner(System.in);
    public boolean getChoiceContinueRoll () {
        System.out.println(playerName + ", do you want to roll the dice (enter " + Displayer.ANSI_YELLOW + "R" + Displayer.ANSI_RESET +
                ") or end your turn (enter " + Displayer.ANSI_YELLOW + "E" + Displayer.ANSI_RESET + ")?");
        String answer = input.nextLine();
        while (!answer.equals("R") && !answer.equals("E")) {
            System.out.println(Displayer.ANSI_RED + "Invalid input =(" + Displayer.ANSI_RESET);
            System.out.println("Please enter '" + Displayer.ANSI_YELLOW + "R" + Displayer.ANSI_RESET + "' to roll the dice(s) or '"
                    + Displayer.ANSI_YELLOW + "E" + Displayer.ANSI_RESET + "' if you wish to end your turn.");
            answer = input.nextLine();
        }
        return answer.equals("R");
    }

    public boolean getChoiceAnotherRoll () {
        System.out.println(playerName + ", do you want to start another round (enter " + Displayer.ANSI_YELLOW + "Y" + Displayer.ANSI_RESET
                + ") or end your turn (enter " + Displayer.ANSI_YELLOW + "N" + Displayer.ANSI_RESET + ")?");
        String answer = input.nextLine();
        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.println(Displayer.ANSI_RED + "Invalid input =(" + Displayer.ANSI_RESET);
            System.out.println("Please enter '" + Displayer.ANSI_YELLOW + "Y" + Displayer.ANSI_RESET + "' to start another round or '"
                    + Displayer.ANSI_YELLOW + "N" + Displayer.ANSI_RESET + "' if you wish to end your turn.");
            answer = input.nextLine();
        }
        return answer.equals("Y");
    }

    public boolean getChoiceDisplayScores () {
        System.out.println(playerName + ", do you want to start the round (enter " + Displayer.ANSI_YELLOW + "R" + Displayer.ANSI_RESET
                + ") or display the scores (enter " + Displayer.ANSI_YELLOW + "D" + Displayer.ANSI_RESET + ")?");
        String answer = input.nextLine();
        while (!answer.equals("R") && !answer.equals("D")) {
            System.out.println(Displayer.ANSI_RED + "Invalid input =(" + Displayer.ANSI_RESET);
            System.out.println("Please enter '" + Displayer.ANSI_YELLOW + "R" + Displayer.ANSI_RESET + "' to start the round or '"
                    + Displayer.ANSI_YELLOW + "D" + Displayer.ANSI_RESET + "' if you wish to display the scores.");
            answer = input.nextLine();
        }
        return answer.equals("D");
    }

    /**
     * @pre takes number of rolled Dice
     * @post returns valid answer from player
     */
    public String getChoiceDice (int activeDice) {
        System.out.println(playerName + " choose at least one valid die or " +
                "triplet by entering the index (" + Displayer.ANSI_YELLOW + "e.g. 2 or 2,3,4" + Displayer.ANSI_RESET + "):");
        String answer = input.nextLine();
        while (!hasValidIndex(answer, activeDice)) {
            System.out.println(Displayer.ANSI_RED + "Invalid input =(" + Displayer.ANSI_RESET);
            System.out.println(playerName + " choose at least one valid die or " +
                    "triplet by entering the index (" + Displayer.ANSI_YELLOW + "e.g. 2 or 2,3,4" + Displayer.ANSI_RESET + "):");
            answer = input.nextLine();
        }
        return answer;
    }

    public void getAnotherRoll () {
        System.out.println(playerName + ", enter " + Displayer.ANSI_YELLOW + "R" + Displayer.ANSI_RESET + " to roll your dice again:");
        String answer = input.nextLine();
        while (!answer.equals("R")) {
            System.out.println(Displayer.ANSI_RED + "Invalid input =(" + Displayer.ANSI_RESET);
            System.out.println("Please enter '" + Displayer.ANSI_YELLOW + "R" + Displayer.ANSI_RESET + "' to roll the dice.");
            answer = input.nextLine();
        }
    }

    @Override
    public int compareTo(Player player) {
        return playerName.compareToIgnoreCase(player.getPlayerName());
    }


}
