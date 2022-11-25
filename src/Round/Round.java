package Round;

import Cards.AbstractCard;
import Player.Player;

import java.util.*;

import static Helpers.ChoiceHelper.*;

public class Round {
    private static Scanner input = new Scanner(System.in);
    public static void playRound (List<Player> players, Stack<AbstractCard> cardStack) {
        Collections.sort(players);
        for (Player activePlayer : players) {
            System.out.println(activePlayer.getPlayerName() + " do you want to roll the dice (enter R) or display the current scores (enter D)?");
            String answer = input.nextLine();
            checkAnswerRandD(answer);
            while (answer.equals("D")) {
                //Displayer.displayScores(players);
                System.out.println(activePlayer.getPlayerName() + " if you wish to roll the dice enter R:");
                checkAnswerRandD(answer);
            }
            activePlayer.updatePlayerScore(playTurn(activePlayer, cardStack));

        }
    }

    public static int playTurn (Player activePlayer, Stack<AbstractCard> cardStack) {
        int activeDice = 6;
        List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
        Displayer.displayDice(rolledDice);
        System.out.println(activePlayer.getPlayerName() + " choose at least one valid die or triplet by entering the index (e.g. 2 or 2,3,4):");
        String answer = input.nextLine();
        checkDieIndex(answer, activeDice);
        checkChoiceValidity(answer, rolledDice);
        return 1;
    }

    public static void playBonusCard (int bonus) {
    }

    public static void playCloverLeafCard () {
    }

    public static void playFireWorkCard () {
    }

    public static void playPlusMinusCard () {
    }

    public static void playStopCard () {
    }

    public static void playStraightCard () {
    }

    public static void playX2Card () {
    }
}
