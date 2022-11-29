package Round;

import Cards.*;
import Gamestate.Displayer;
import Helpers.DiceRoller;
import Player.Player;

import java.util.*;

import static Helpers.InputValidator.*;
import static Helpers.ScoreCalculator.*;

public class Round {

    private static Deck cardDeck;

    private static Player activePlayer;

    private static List<Player> highestScoringPlayers = new ArrayList<>();

    private static Scanner input = new Scanner(System.in);

    private static int numberOfTuttos;

    private static AbstractCard activeCard;

    public static void playRound (List<Player> players, Deck aDeck) {
        cardDeck = aDeck;
        Collections.sort(players);
        setHighestScoringPlayer(players);
        for (Player aPlayer : players) {
            activePlayer = aPlayer;
            boolean displayScores = activePlayer.getChoiceDisplayScores();
            if (displayScores) {
                Displayer.displayScores(players);
                while (displayScores) {
                    System.out.println(activePlayer.getPlayerName() + " if you wish to roll the dice enter R:");
                    String answer = input.nextLine();
                    displayScores = answer.equals("R");
                }
            }
            activeCard = cardDeck.getTopCard();
            activeCard.playTurn();
        }
    }

    public static void setHighestScoringPlayer(List<Player> players) {
        highestScoringPlayers.add(players.get(0));
        for (Player player : players) {
            if (player.getPlayerScore() > highestScoringPlayers.get(0).getPlayerScore()) {
                highestScoringPlayers.clear();
                highestScoringPlayers.add(player);
            } else if (player.getPlayerScore() == highestScoringPlayers.get(0).getPlayerScore()) {
                highestScoringPlayers.add(player);
            }
        }
    }

    private static void playBonusAndDoubleTurn (int bonus, boolean isDouble) {
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        int turnScore = 0;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            turnIsActive = checkIsValidRoll(rolledDice);
            if (!turnIsActive) {
                System.out.println("Tough luck!");
                System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                break;
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAside = checkChoiceValidity(answer, rolledDice);
            turnScore = calculateScore(diceSetAside);
            activeDice -= countDiceSetAside(diceSetAside);
            if (activeDice == 0) {
                turnIsActive = tuttoBehavior(activePlayer);
                turnScore += isDouble ? turnScore*2 : bonus;
            } else if (turnIsActive && activeDice == 0) {
                activeCard = cardDeck.getTopCard();
                activeCard.playTurn();
            } else {
                turnIsActive = activePlayer.getChoiceContinueRoll();
            }
        }
        activePlayer.updatePlayerScore(turnScore);
    }

    private static boolean tuttoBehavior (Player activePlayer) {
        System.out.println("Congratulations " + activePlayer.getPlayerName() + "! You have a Tutto!");
        boolean anotherRound = activePlayer.getChoiceAnotherRound();
        numberOfTuttos++;
        return anotherRound;
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
        Displayer.displayCard(activeCard);
        playBonusAndDoubleTurn(bonus, false);
    }

    public static void playX2Card () {
        Displayer.displayCard(activeCard);
        playBonusAndDoubleTurn(0, true);
    }

    public static void playStopCard () {
        Displayer.displayCard(activeCard);
        System.out.println("You drew a Stop card... better luck next round!");
    }

    public static void playFireWorkCard () {
        Displayer.displayCard(activeCard);
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        int turnScore = 0;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            activePlayer.getAnotherRoll();
            List<Integer> diceSetAside = DiceRoller.getAllValidDice(rolledDice);
            turnScore += calculateScore(diceSetAside);
            activeDice -= countDiceSetAside(diceSetAside);
            if (diceSetAside.size() == 0) { turnIsActive = false; }
        }
        activePlayer.updatePlayerScore(turnScore);
    }

    public static void playPlusMinusCard () {
        Displayer.displayCard(activeCard);
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            turnIsActive = checkIsValidRoll(rolledDice);
            if (!turnIsActive) {
                System.out.println("Tough luck!");
                System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                break;
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAside = checkChoiceValidity(answer, rolledDice);
            activeDice -= countDiceSetAside(diceSetAside);
            if (activeDice == 0) {
                System.out.println("Congratulations you scored a Tutto! You get 1000 points!");
                turnIsActive = false;
            }
        }
        activePlayer.updatePlayerScore(1000);
        for (Player highestScoringPlayer : highestScoringPlayers) {
            highestScoringPlayer.subtractPlayerScore(1000);
        }
    }

    public static void playCloverLeafCard () {
        Displayer.displayCard(activeCard);
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            turnIsActive = checkIsValidRoll(rolledDice);
            if (!turnIsActive) {
                System.out.println("Tough luck!");
                System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                break;
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAside = checkChoiceValidity(answer, rolledDice);
            activeDice -= countDiceSetAside(diceSetAside);
            if (activeDice == 0 && numberOfTuttos < 2) {
                System.out.println("Congratulations " + activePlayer.getPlayerName() + ", you got a Tutto! " +
                        "Get a second one to win the game!");
                numberOfTuttos++;
                activePlayer.getAnotherRoll();
            } else if (activeDice == 0 && numberOfTuttos == 2) {
                System.out.println("Congratulations! " + activePlayer.getPlayerName() + " won the game!");
            } else {
                activePlayer.getAnotherRoll();
            }
        }
    }

    public static void playStraightCard () {
        Displayer.displayCard(activeCard);
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        List<Integer> diceSetAside;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            if (diceSetAside == null) {
                turnIsActive = checkIsValidRollStraight(rolledDice, null);
                if (!turnIsActive) {
                    System.out.println("Tough luck!");
                    System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                    break;
                }
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            diceSetAside = checkChoiceValidityStraight(answer, rolledDice, diceSetAside);
            activeDice -= countDiceSetAside(diceSetAside);
            if (activeDice == 0) {
                System.out.println("Congratulations you scored a Straight! You get 2000 points!");
                turnIsActive = false;
            }
        }
        activePlayer.updatePlayerScore(2000);
    }
}
