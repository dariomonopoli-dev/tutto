package Player;

import java.util.List;
import java.util.Scanner;
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
        playerScore += additionalScore;
    }

    Scanner input = new Scanner(System.in);
    public boolean getChoiceContinueRoll () {
        System.out.println("Do you want to roll the dice (enter R) or end your turn (enter E)?");
        String answer = input.nextLine();
        while (!answer.equals("R") && !answer.equals("E")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'R' to roll the dice(s) or 'E' if you wish to end your turn.");
            answer = input.nextLine();
        }
        return answer.equals("R");
    }
    public boolean getChoiceAnotherRound () {
        System.out.println("Do you want to start another round (enter Y) or end your turn (enter N)?");
        String answer = input.nextLine();
        while (!answer.equals("Y") && !answer.equals("N")) {
            System.out.println("Invalid input =(");
            System.out.println("Please enter 'Y' to start another round or 'N' if you wish to end your turn.");
            answer = input.nextLine();
        }
        return answer.equals("Y");
    }

    @Override
    public int compareTo(Player player) {
        return playerName.compareToIgnoreCase(player.getPlayerName());
    }
}
