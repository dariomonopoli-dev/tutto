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

    private static final List<Player> highestScoringPlayers = new ArrayList<>();

    private static int numberOfTuttos;

    private static AbstractCard activeCard;

    private static List<Player> currentPlayers;

    private static int turnScore = 0;

    public static void playRound (List<Player> players, Deck aDeck) {
        currentPlayers = players;
        cardDeck = aDeck;
        Collections.sort(players);
        setHighestScoringPlayer(players);
        for (Player aPlayer : players) {
            activePlayer = aPlayer;
            boolean displayScores = activePlayer.getChoiceDisplayScores();
            if (displayScores) {
                Displayer.displayScores(players);
                while (displayScores) {
                    displayScores = activePlayer.getChoiceDisplayScores();
                }
            }
            activeCard = cardDeck.getTopCard();
            activeCard.playTurn();
            activePlayer.increasePlayerScore(turnScore);
            System.out.println(activePlayer.getPlayerName() + ", you scored " +
                    Displayer.ANSI_PURPLE + turnScore + Displayer.ANSI_RESET + " points!");
            turnScore = 0;
        }
    }

    public static List<Player> setHighestScoringPlayer(List<Player> players) {
        highestScoringPlayers.clear();
        highestScoringPlayers.add(players.get(0));
        for (Player player : players) {
            if (player.getPlayerScore() > highestScoringPlayers.get(0).getPlayerScore()) {
                highestScoringPlayers.clear();
                highestScoringPlayers.add(player);
            } else if (player.getPlayerScore() == highestScoringPlayers.get(0).getPlayerScore() &&
                    !highestScoringPlayers.contains(player)) {
                highestScoringPlayers.add(player);
            }
        }
        return highestScoringPlayers;
    }

    private static void playBonusAndDoubleTurn (int bonus, boolean isDouble) {
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        int intermediateScore = 0;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            turnIsActive = checkIsValidRoll(rolledDice);
            if (!turnIsActive) {
                System.out.println("Tough luck!");
                System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                turnScore = 0;
                return;
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAsideThrow = checkChoiceValidity(answer, rolledDice);
            intermediateScore += calculateScore(diceSetAsideThrow);
            activeDice -= diceSetAsideThrow.size();
            if (activeDice == 0) {
                turnIsActive = anotherRollAfterTutto(activePlayer, true);
                turnScore += isDouble ? intermediateScore * 2 : intermediateScore + bonus;
                if (turnIsActive) {
                    activeCard = cardDeck.getTopCard();
                    activeCard.playTurn();
                    return;
                }
            } else {
                turnIsActive = activePlayer.getChoiceContinueRoll();
            }
        }
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
        turnScore = 0;
    }

    public static void playFireWorkCard () {
        Displayer.displayCard(activeCard);
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            turnIsActive = checkIsValidRoll(rolledDice);
            if (!turnIsActive) {
                System.out.println(activePlayer.getPlayerName()+ ", you rolled a null, your turn is finished...");
                System.out.println("You score all points you have accumulated this turn!");
                return;
            }
            activePlayer.getAnotherRoll();
            List<Integer> diceSetAside = DiceRoller.getAllValidDice(rolledDice);
            turnScore += calculateScore(diceSetAside);
            activeDice -= diceSetAside.size();
            if (activeDice == 0) {
                activeDice = 6;
            }
        }
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
                turnScore = 0;
                return;
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAside = checkChoiceValidity(answer, rolledDice);
            activeDice -= diceSetAside.size();
            if (activeDice == 0) {
                turnIsActive = false;
            }
        }
        turnScore += 1000;
        for (Player highestScoringPlayer : highestScoringPlayers) {
            if (!highestScoringPlayer.equals(activePlayer)) {
                highestScoringPlayer.decreasePlayerScoreBy1000();
            }
        }
        if (anotherRollAfterTutto(activePlayer, true)) {
            activeCard = cardDeck.getTopCard();
            activeCard.playTurn();
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
                turnScore = 0;
                return;
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAside = checkChoiceValidity(answer, rolledDice);
            activeDice -= diceSetAside.size();
            if (activeDice == 0 && numberOfTuttos == 0) {
                System.out.println("Congratulations " + activePlayer.getPlayerName() + ", you got a Tutto! " +
                        "Get a second one to win the game!");
                numberOfTuttos++;
                activeDice = 6;
                activePlayer.getAnotherRoll();
            } else if (activeDice == 0 && numberOfTuttos == 1) {
                highestScoringPlayers.clear();
                highestScoringPlayers.add(activePlayer);
                Displayer.displayWinnerScreen(highestScoringPlayers, currentPlayers);
                System.exit(0);
            }
        }
    }

    public static void playStraightCard () {
        Displayer.displayCard(activeCard);
        numberOfTuttos = 0;
        int activeDice = 6;
        boolean turnIsActive = true;
        List<Integer> diceSetAsideTurn = new ArrayList<>();
        while (turnIsActive) {
            List<Integer> rolledDice = DiceRoller.rollDice(activeDice);
            Displayer.displayDice(rolledDice);
            if (!diceSetAsideTurn.isEmpty()) {
                turnIsActive = checkIsValidRollStraight(rolledDice, diceSetAsideTurn);
                if (!turnIsActive) {
                    System.out.println("Tough luck!");
                    System.out.println(activePlayer.getPlayerName() + " your turn is finished...");
                    turnScore = 0;
                    return;
                }
            }
            String answer = activePlayer.getChoiceDice(activeDice);
            List<Integer> diceSetAsideThrow = checkChoiceValidityStraight(answer, rolledDice, diceSetAsideTurn);
            activeDice -= diceSetAsideThrow.size();
            diceSetAsideTurn.addAll(diceSetAsideThrow);
            if (activeDice == 0) {
                System.out.println("Congratulations you scored a Straight! You get 2000 points!");
                turnIsActive = false;
            }
        }
        turnScore += 2000;
        if (anotherRollAfterTutto(activePlayer, false)) {
            activeCard = cardDeck.getTopCard();
            activeCard.playTurn();
        }
    }

    private static boolean anotherRollAfterTutto (Player activePlayer, boolean displayTuttoMessage) {
        if (displayTuttoMessage) {
            System.out.println("Congratulations " + activePlayer.getPlayerName() + "! You have a Tutto!");
        }
        boolean anotherRound = activePlayer.getChoiceAnotherRoll();
        numberOfTuttos++;
        return anotherRound;
    }
}
