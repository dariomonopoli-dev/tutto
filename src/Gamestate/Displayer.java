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
    public static final String BLUE_BOLD = "\033[1;34m";

    protected static String messageWelcomeScreen() {
        String welcomeMessage = ANSI_BLUE+ """
            ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ████████╗██╗   ██╗████████╗████████╗ ██████╗
            ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══██╔══╝██║   ██║╚══██╔══╝╚══██╔══╝██╔═══██╗
            ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝       ██║   ╚██████╔╝   ██║      ██║   ╚██████╔╝
             ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝        ╚═╝    ╚═════╝    ╚═╝      ╚═╝    ╚═════╝""";
        return welcomeMessage;

    }
    public static void displayWelcomeScreen() {
        System.out.println(messageWelcomeScreen());
        System.out.println("Developed by Valentin Meyer, Dario Monopoli, Lennart Töllke and Remo Wiget"+ANSI_RESET);

    }

    protected static String messageWin() {
        String winnerMessage = GREEN_BOLD_BRIGHT +"""
            ██╗    ██╗███████╗    ██╗  ██╗ █████╗ ██╗   ██╗███████╗     █████╗     ██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ ██╗██╗
            ██║    ██║██╔════╝    ██║  ██║██╔══██╗██║   ██║██╔════╝    ██╔══██╗    ██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗██║██║
            ██║ █╗ ██║█████╗      ███████║███████║██║   ██║█████╗      ███████║    ██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝██║██║
            ██║███╗██║██╔══╝      ██╔══██║██╔══██║╚██╗ ██╔╝██╔══╝      ██╔══██║    ██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗╚═╝╚═╝
            ╚███╔███╔╝███████╗    ██║  ██║██║  ██║ ╚████╔╝ ███████╗    ██║  ██║    ╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║██╗██╗
             ╚══╝╚══╝ ╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝    ╚═╝  ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝"""+ ANSI_RESET;
        return winnerMessage;

    }
    public static void displayWinnerScreen(List<Player> winningPlayers, List<Player> players) {
        System.out.println(messageWin());
        System.out.println("Congratulations to: ");
        for (Player player : winningPlayers) {
            System.out.println(GREEN_BOLD_BRIGHT + player.getPlayerName() + ANSI_RESET);
        }
        System.out.println();
        displayScores(players);
    }

    public static void displayScores(List<Player> players) {
        System.out.println("┌────────────────────┬─────────────┐");
        System.out.println("│ " + BLUE_BOLD + "Player " + ANSI_RESET + "            │ " + BLUE_BOLD + "Score" + ANSI_RESET + "       │");
        for(Player player : players) {
            System.out.println("│ " + player.getPlayerName() + " ".repeat(18-player.getPlayerName().length()) + " │ " + player.getPlayerScore() + " ".repeat(11-String.valueOf(player.getPlayerScore()).length()) + " │");
        }
        System.out.println("└────────────────────┴─────────────┘");
    }

    protected static String messageCard(AbstractCard card) {
        String messageCard = card.getGraphicalRepresentation();
        return messageCard;

    }
    public static void displayCard(AbstractCard card) {
        System.out.println(messageCard(card));
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
