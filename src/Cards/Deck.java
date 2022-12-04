package Cards;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private static final Deck uniqueInstance = new Deck();
    private static Stack<AbstractCard> deck;

    public Deck(){
        deck = new Stack<>();
        initializeDeck();
    }

    // for Test purposes
    public Deck(AbstractCard card){
        deck = new Stack<>();
        deck.push(card);
    }

    public void initializeDeck() {
        deck.clear();

        int numberOfBonusCards200 = 5;
        for (int i = 0; i < numberOfBonusCards200; i++) {
            deck.push(CardBonus.getInstance(200));
        }
        int numberOfBonusCards300 = 5;
        for (int i = 0; i < numberOfBonusCards300; i++) {
            deck.push(CardBonus.getInstance(300));
        }
        int numberOfBonusCards400 = 5;
        for (int i = 0; i < numberOfBonusCards400; i++) {
            deck.push(CardBonus.getInstance(400));
        }
        int numberOfBonusCards500 = 5;
        for (int i = 0; i < numberOfBonusCards500; i++) {
            deck.push(CardBonus.getInstance(500));
        }
        int numberOfBonusCards600 = 5;
        for (int i = 0; i < numberOfBonusCards600; i++) {
            deck.push(CardBonus.getInstance(600));
        }

        int numberOfFireworksCards = 5;
        for (int i = 0; i < numberOfFireworksCards; i++) {
            deck.push(CardFireworks.getInstance());
        }

        int numberOfStopCards = 10;
        for (int i = 0; i < numberOfStopCards; i++) {
            deck.push(CardStop.getInstance());
        }

        int numberOfPlusMinusCards = 5;
        for (int i = 0; i < numberOfPlusMinusCards; i++) {
            deck.push(CardPlusMinus.getInstance());
        }

        int numberOfStraightCards = 5;
        for (int i = 0; i < numberOfStraightCards; i++) {
            deck.push(CardStraight.getInstance());
        }

        int numberOfX2Cards = 5;
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

    public boolean isEmpty() {
        return (deck.size() == 0);
    }
    public static Deck getInstance(){
    return uniqueInstance;
    }
}

