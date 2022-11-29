package Cards;


import Cards.*;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private static final Deck uniqueInstance = new Deck();
    private static Stack<AbstractCard> deck;

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

    private Deck(){
        deck = new Stack<>();
        initializeDeck();
    }

    public void initializeDeck() {
        for (int i = 0; i < numberOfBonusCards200; i++) {
            deck.push(CardBonus.getInstance(200));
        }
        for (int i = 0; i < numberOfBonusCards300; i++) {
            deck.push(CardBonus.getInstance(300));
        }
        for (int i = 0; i < numberOfBonusCards400; i++) {
            deck.push(CardBonus.getInstance(400));
        }
        for (int i = 0; i < numberOfBonusCards500; i++) {
            deck.push(CardBonus.getInstance(500));
        }
        for (int i = 0; i < numberOfBonusCards600; i++) {
            deck.push(CardBonus.getInstance(600));
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

        shuffle();
    }

    public AbstractCard getTopCard() {
        AbstractCard currentCard = deck.pop();
        if (deck.isEmpty()){
            initializeDeck();
            return currentCard;
        }
        return currentCard;
    }


    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int getDeckSize() {
        return deck.size();
    }

    private boolean isEmpty() {
        return (deck.size() == 0);
    }
    public static Deck getInstance(){
    return uniqueInstance;
    }
}

