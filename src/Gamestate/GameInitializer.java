package Gamestate;

import Player.Player;
import java.util.ArrayList;
import java.util.Scanner;


public class GameInitializer {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getPlayerNumber() {
        System.out.println("Before the game can start, please enter how many players you are:");
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                scanner.nextLine(); // "throws away" the leftover \n so that the next "nextLine" doesn't take it
                if (inputNumber < 2 || inputNumber > 4) {
                     System.out.println("This game is only playable by 2-4 players, please enter a valid number!");
                 } else {
                     return inputNumber;
                 }
            } catch (Exception e) {
                System.out.println("Something went wrong :(");
                System.out.println("please try again!");
                scanner.next(); // advances scanner so that it doesn't get caught in endless while loop of exceptions
            }
        }
    }

    private static String getPlayerName(int number) {
        System.out.println("Player number "+ number +", please enter your Name:");
        while (true) {
            try {
                String inputName = scanner.nextLine();
                if (inputName.length() > 25) {
                    System.out.println("This name is waaay to long!");
                    System.out.println("Please enter a name that has at most 25 letters");
                } else if (inputName.length() < 1) {
                    System.out.println("You have to type in a name!");
                    System.out.println("Please enter at least one character");
                } else {
                    return inputName;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong :(");
                System.out.println("please try again!");
            }
        }
    }

    protected static ArrayList<Player> getPlayers() {
        int numberOfPlayers = getPlayerNumber();
        ArrayList<Player> playerInstances = new ArrayList<>();

        while(playerInstances.size() < numberOfPlayers) {
            String name = getPlayerName(playerInstances.size()+1);
            playerInstances.add(new Player(name));
        }
        return playerInstances;
    }

    protected static int getWinningScore(){
        System.out.println("Now you can decide how many points are needed to win the game (the default value is 6000)");
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                scanner.nextLine();
                if (inputNumber < 1) {
                    System.out.println("Do you even want to play? The winning points can't be smaller than 1!");
                } else {
                    return inputNumber;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong :(");
                System.out.println("please try again!");
                scanner.next();
            }
        }
    }
}
