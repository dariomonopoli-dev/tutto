package Cards;


import Cards.*;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private static Stack<AbstractCard> deck = new Stack<AbstractCard>();
    private final int numberOfBonusCards200 = 5;
    private final int numberOfBonusCards300 = 5;
    private final int numberOfBonusCards400 = 5;
    private final int numberOfBonusCards500 = 5;
    private final int numberOfBonusCards600 = 5;
    private final int numberOfFireworksCards = 5;
    private final int numberOfStopCards = 10;
    private final int numberOfPlusMinusCards = 5;
    private final int numberOfStraightCards = 5;
    private final int numberOfX2Cards = 5;

    public void initializeDeck() {
        for (int i = 0; i < numberOfBonusCards200; i++) {
            deck.push(new CardBonus(200));
        }
        for (int i = 0; i < numberOfBonusCards300; i++) {
            deck.push(new CardBonus(300));
        }
        for (int i = 0; i < numberOfBonusCards400; i++) {
            deck.push(new CardBonus(400));
        }
        for (int i = 0; i < numberOfBonusCards500; i++) {
            deck.push(new CardBonus(500));
        }
        for (int i = 0; i < numberOfBonusCards600; i++) {
            deck.push(new CardBonus(600));
        }

        for (int i = 0; i < numberOfFireworksCards; i++) {
            deck.push(CardFireworks.getInstance());
        }

        for (int i = 0; i < numberOfStopCards; i++) {
            deck.push(CardStop.getInstance());
        }

        for (int i = 0; i < numberOfPlusMinusCards; i++) {
            deck.push(CardPlusMinus.getInstance());
        }

        for (int i = 0; i < numberOfStraightCards; i++) {
            deck.push(CardStraight.getInstance());
        }

        for (int i = 0; i < numberOfX2Cards; i++) {
            deck.push(CardX2.getInstance());
        }

        deck.push(CardCloverleaf.getInstance());

    }

    public AbstractCard getTopCard(Stack<AbstractCard> s) {
        AbstractCard currentCard = s.pop();
        if (s.isEmpty()){
            System.out.println("Re-shuffling deck");
            initializeDeck();
            System.out.println("Deck has been shuffled");
            return currentCard;

        }
        return currentCard;
    }


    public void shuffle(Stack<AbstractCard> deck) {
        System.out.println("Shuffling deck...");
        Collections.shuffle(deck);
        System.out.println("Deck has been shuffled");
    }

    public Stack<AbstractCard> getDeck() {
        return deck;
    }

    public int getDeckSize() {
        return deck.size();
    }

    private boolean isEmpty() {
        return (deck.size() == 0);
    }
}


