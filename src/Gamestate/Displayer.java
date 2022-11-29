package Gamestate;

import Cards.AbstractCard;
import Player.Player;

import java.util.List;

public class Displayer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\033[0;93m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";



    public static void displayDice(List<Integer> dice) {
        for(int die : dice) {
            System.out.println(die);
        }
    }

    public static void displayScores(List<Player> players) {
        for(Player player : players) {
            System.out.println(player.getPlayerScore());
        }
    }
    public static void displayCard(AbstractCard card) {
        System.out.println(card.getCardName());
    }
    
    public static void displayWelcomeScreen() {
        System.out.println(ANSI_BLUE+
                "██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ████████╗██╗   ██╗████████╗████████╗ ██████╗ \n" +
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══██╔══╝██║   ██║╚══██╔══╝╚══██╔══╝██╔═══██╗\n" +
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║\n" +
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║\n" +
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝       ██║   ╚██████╔╝   ██║      ██║   ╚██████╔╝\n" +
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝        ╚═╝    ╚═════╝    ╚═╝      ╚═╝    ╚═════╝ ");
        System.out.println("Developed by Valentin Meyer, Dario Monopoli, Lennart Töllke and Remo Wiget"+ANSI_RESET);
    }

    public static void displayWinnerScreen() {
    }
}
