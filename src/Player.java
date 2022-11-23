import java.util.Scanner;
public class Player {
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
    public void setPlayerScore (int additionalScore) {
        playerScore += additionalScore;
    }
    public boolean getChoiceRorE () {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to roll the dice (enter R) or end your turn (enter E)?");
        String answer = input.nextLine();
        System.out.println(answer == "R");
        while (answer != "R") {
            System.out.println("Invalid input =(");
            System.out.println("Please enter R to roll the dice(s) or E if you wish to end your turn.");
            answer = input.nextLine();
        }
        System.out.println("Your answer is: " + answer);
        return true;
    }
    public static void main (String[] args) {
        Player testPlayer = new Player("Jonas");
        testPlayer.getChoiceRorE();
    }

}
