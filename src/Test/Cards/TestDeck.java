package Test.Cards;

import Cards.Deck;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TestDeck {

    @Test
    void TestGetTopCard() {
        final Deck d = new Deck();
        assertEquals(d.getTopCard().getClass().toString().substring(6,11), d.getTopCard().toString().substring(0,5));
        for (int i = 0; i<56; i++) {
            d.getTopCard();
        }
    }

    @Test
    void TestShuffle(){
        final Deck deck1 = new Deck();
        deck1.shuffle();
        Stack<Object> stack1 = new Stack<>();
        for(int i =0; i < 10; i++){
            stack1.push(deck1.getTopCard());
        }

        Stack<Object> stack2 = new Stack<>();
        final Deck deck2 = new Deck();
        for(int i =0; i < 10; i++){
            stack2.push(deck2.getTopCard());
        }
        assertNotEquals(stack1, stack2);
    }


    @Test
    void TestGetDeckSize() {
        final Deck deck = new Deck();
        deck.initializeDeck();
        assertEquals(56, deck.getDeckSize());
    }

    @Test
    void TestIsEmpty() {
        final Deck deck = new Deck();
        assertFalse(deck.isEmpty());
    }

    @Test
    void TestGetInstance() {
        final Deck deck = new Deck();
        deck.initializeDeck();
        final Deck deckInstance = deck.getInstance();
        assertEquals(deckInstance, deck.getInstance());
    }
}

