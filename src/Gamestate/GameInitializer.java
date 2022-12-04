package Gamestate;

import Player.Player;
import java.util.ArrayList;
import java.util.Scanner;


public class GameInitializer {


    protected static int getPlayerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Before the game can start, " + Displayer.ANSI_YELLOW + "please enter how many players you are:" + Displayer.ANSI_RESET);
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                scanner.nextLine(); // "throws away" the leftover \n so that the next "nextLine" doesn't take it
                if (inputNumber < 2 || inputNumber > 4) {
                     System.out.println(Displayer.ANSI_RED + "This game is only playable by 2-4 players, please enter a valid number!" + Displayer.ANSI_RESET);
                 } else {
                     return inputNumber;
                 }
            } catch (Exception e) {
                System.out.println(Displayer.ANSI_RED + "Something went wrong :(" + Displayer.ANSI_RESET);
                System.out.println("please try again!");
                scanner.next(); // advances scanner so that it doesn't get caught in endless while loop of exceptions
            }
        }
    }

    protected static String getPlayerName(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player number "+ number +", please enter your " + Displayer.ANSI_YELLOW + "Name" + Displayer.ANSI_RESET + ":");
        while (true) {
            try {
                String inputName = scanner.nextLine();
                if (inputName.length() > 18) {
                    System.out.println(Displayer.ANSI_RED + "This name is waaay to long!" + Displayer.ANSI_RESET);
                    System.out.println("Please enter a name that has at most 18 letters");
                } else if (inputName.length() < 1) {
                    System.out.println(Displayer.ANSI_RED + "You have to type in a name!" + Displayer.ANSI_RESET);
                    System.out.println("Please enter at least one character");
                } else {
                    return inputName;
                }
            } catch (Exception e) {
                System.out.println(Displayer.ANSI_RED + "Something went wrong :(" + Displayer.ANSI_RESET);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Now you can decide how many " + Displayer.ANSI_YELLOW + "points are needed to win the game"
                + Displayer.ANSI_RESET + " (the default value is 6000)");
        while (true) {
            try {
                int inputNumber = scanner.nextInt();
                scanner.nextLine();
                if (inputNumber < 1) {
                    System.out.println("Do you even want to play? " + Displayer.ANSI_RED + "The winning points can't be smaller than 1!" + Displayer.ANSI_RESET);
                } else {
                    return inputNumber;
                }
            } catch (Exception e) {
                System.out.println(Displayer.ANSI_RED + "Something went wrong :(" + Displayer.ANSI_RESET);
                System.out.println("please try again!");
                scanner.next();
            }
        }
    }
}
