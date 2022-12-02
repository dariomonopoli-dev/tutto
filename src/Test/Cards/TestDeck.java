package Test.Cards;

import Cards.AbstractCard;
import org.junit.jupiter.api.Test;
import Cards.Deck;


import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class TestDeck {

    @Test
    void isEmpty() {
        final Deck deck = new Deck();
        assertFalse(deck.isEmpty());

    }


    @Test
    void getTopCard() {
        final Deck d = new Deck();
        assertEquals(d.getTopCard().getClass().toString().substring(6,11), d.getTopCard().toString().substring(0,5));
        for (int i = 0; i<56; i++) {
            d.getTopCard();
        }
    }
    @Test
    void getDeckSize() {
        final Deck deck = new Deck();
        deck.initializeDeck();
        assertEquals(56, deck.getDeckSize());
    }

    @Test
    void getInstance() {
        final Deck deck = new Deck();
        deck.initializeDeck();
        final Deck deckInstance = deck.getInstance();
        assertEquals(deckInstance, deck.getInstance());
    }



    }

