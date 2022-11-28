package Round;

import Cards.AbstractCard;
import Cards.Deck;
import Gamestate.Displayer;
import Helpers.DiceRoller;
import Player.Player;

import java.util.*;

import static Helpers.ChoiceHelper.*;
import static Helpers.ScoreCalculator.*;

public class Round {
    private static Scanner input = new Scanner(System.in);

    private static int numberOfTuttos = 0;

    public static void playRound (List<Player> players, Deck cardDeck) {
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
            playTurn(activePlayer, cardDeck);
        }
    }

    private static void playTurn (Player activePlayer, Deck cardDeck) {
        int activeDice = 6;
        boolean turnIsActive = true;
        int turnScore = 0;
        AbstractCard activeCard = cardDeck.getTopCard();
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            turnIsActive = checkIsValidRoll(rolledDice);
            if (!turnIsActive) {
                System.out.println("Tough luck!");
                System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                break;
            }
            System.out.println(activePlayer.getPlayerName() + " choose at least one valid die or " +
                    "triplet by entering the index (e.g. 2 or 2,3,4):");
            String answer = input.nextLine();
            checkDieIndex(answer, activeDice);
            List<Integer> diceSetAside = checkChoiceValidity(answer, rolledDice);
            turnScore = calculateScore(diceSetAside, activeCard);
            activeDice -= countDiceSetAside(diceSetAside);
            if (activeDice == 0) {
                turnIsActive = tuttoBehavior(activePlayer);
            }

        }
        activePlayer.updatePlayerScore(turnScore);
    }

    private static boolean tuttoBehavior (Player activePlayer) {
        System.out.println("Congratulations " + activePlayer.getPlayerName() + "! You have a Tutto!");
        System.out.println("If you wish to continue and roll the dice enter R or " +
                "if you want to end your turn please enter E:");
        String answer = input.nextLine();
        checkAnswerRandE(answer);
        numberOfTuttos++;
        return answer.equals("R");
    }

    private static int countDiceSetAside(List<Integer> diceSetAside) {
        int total = 0;
        if (diceSetAside.size() > 0) {
            for (int dice : diceSetAside) {
                total += (dice > 6) ? 3 : 1;
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

    public static void main (String[] args) {
        Player somePlayer = new Player("Jonas");
        System.out.println(tuttoBehavior(somePlayer));
    }
}
