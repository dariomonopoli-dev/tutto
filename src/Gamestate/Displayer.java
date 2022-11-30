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

    public static void displayWelcomeScreen() {
        System.out.println(ANSI_BLUE+ """
            ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ████████╗██╗   ██╗████████╗████████╗ ██████╗
            ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══██╔══╝██║   ██║╚══██╔══╝╚══██╔══╝██╔═══██╗
            ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝       ██║   ╚██████╔╝   ██║      ██║   ╚██████╔╝
             ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝        ╚═╝    ╚═════╝    ╚═╝      ╚═╝    ╚═════╝""");
        System.out.println("Developed by Valentin Meyer, Dario Monopoli, Lennart Töllke and Remo Wiget"+ANSI_RESET);

    }

    public static void displayWinnerScreen(List<Player> winningPlayers) {
        System.out.println(GREEN_BOLD_BRIGHT +"""
            ██╗    ██╗███████╗    ██╗  ██╗ █████╗ ██╗   ██╗███████╗     █████╗     ██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ ██╗██╗
            ██║    ██║██╔════╝    ██║  ██║██╔══██╗██║   ██║██╔════╝    ██╔══██╗    ██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗██║██║
            ██║ █╗ ██║█████╗      ███████║███████║██║   ██║█████╗      ███████║    ██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝██║██║
            ██║███╗██║██╔══╝      ██╔══██║██╔══██║╚██╗ ██╔╝██╔══╝      ██╔══██║    ██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗╚═╝╚═╝
            ╚███╔███╔╝███████╗    ██║  ██║██║  ██║ ╚████╔╝ ███████╗    ██║  ██║    ╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║██╗██╗
             ╚══╝╚══╝ ╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝    ╚═╝  ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝"""+ ANSI_RESET);


    }

    public static void displayScores(List<Player> players) {
        for(Player player : players) {
            System.out.println(player.getPlayerScore());
        }
    }

    public static void displayCard(AbstractCard card) {
        System.out.println(card.getGraphicalRepresentation());
    }

    public static void displayDice(List<Integer> dice) {
        final String[] one = {
                "┌─────────┐",
                "│         │",
                "│    ■    │",
                "│         │",
                "└─────────┘"};
        final String[] two = {
                "┌─────────┐",
                "│  ■      │",
                "│         │",
                "│      ■  │",
                "└─────────┘"};
        final String[] three = {
                "┌─────────┐",
                "│  ■      │",
                "│    ■    │",
                "│      ■  │",
                "└─────────┘"};
        final String[] four = {
                "┌─────────┐",
                "│  ■   ■  │",
                "│         │",
                "│  ■   ■  │",
                "└─────────┘"};
        final String[] five = {
                "┌─────────┐",
                "│  ■   ■  │",
                "│    ■    │",
                "│  ■   ■  │",
                "└─────────┘"};
        final String[] six = {
                "┌─────────┐",
                "│  ■   ■  │",
                "│  ■   ■  │",
                "│  ■   ■  │",
                "└─────────┘"};

        final String[][] diceRepresentations = {one,two,three,four,five,six};

        // Print Dice next to each other
        final int linesOfDiceRepresentation = 5;
        for (int i = 0; i < linesOfDiceRepresentation; i++) {
            for(int die : dice) {
                System.out.print(diceRepresentations[die-1][i] + "  ");
            }
            System.out.println();
        }
        // Print identification numbers beneath them
        for (int idx = 1; idx <= dice.size(); idx++) {
            System.out.print("     " + idx + "       ");
        }
        System.out.println();
    }

}
