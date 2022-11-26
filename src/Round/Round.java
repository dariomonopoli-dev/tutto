package Round;

import Cards.AbstractCard;
import Gamestate.Displayer;
import Helpers.DiceRoller;
import Player.Player;

import java.util.*;

import static Helpers.ChoiceHelper.*;
import static Helpers.ScoreCalculator.*;

public class Round {
    private static Scanner input = new Scanner(System.in);
    public static void playRound (List<Player> players, Stack<AbstractCard> cardStack) {
        Collections.sort(players);
        for (Player activePlayer : players) {
            System.out.println(activePlayer.getPlayerName() + " do you want to roll the dice (enter R) or display the current scores (enter D)?");
            String answer = input.nextLine();
            checkAnswerRandD(answer);
            while (answer.equals("D")) {
                Displayer.displayScores(players);
                System.out.println(activePlayer.getPlayerName() + " if you wish to roll the dice enter R:");
                checkAnswerRandD(answer);
            }
            playTurn(activePlayer, cardStack);
        }
    }
    List<String> someList = Arrays.asList("1", "444", "5");
    List<Integer> someOtherList = Arrays.asList(1, 444, 5);
    private static void playTurn (Player activePlayer, Stack<AbstractCard> cardStack) {
        int activeDice = 6;
        boolean turnIsFinished = false;
        int turnScore = 0;
        DiceRoller.rollDice(activeDice);
        List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
        Displayer.displayDice(rolledDice);
        System.out.println(activePlayer.getPlayerName() + " choose at least one valid die or triplet by entering the index (e.g. 2 or 2,3,4):");
        String answer = input.nextLine();
        checkDieIndex(answer, activeDice);
        List<String> diceSetAside = checkChoiceValidity(answer, rolledDice);
        turnScore = calculateScore(diceSetAside);
        activeDice -= countDiceSetAside(diceSetAside);
        if (turnIsFinished) {activePlayer.updatePlayerScore(turnScore);}
    }

    private static int countDiceSetAside(List<String> diceSetAside) {
        int total = 0;
        if (diceSetAside.size() > 0) {
            for (String dice : diceSetAside) {
                total += (dice.length() > 1) ? 3 : 1;
            }
        }
        return total;
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
