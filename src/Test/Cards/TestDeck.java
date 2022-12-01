package Test.Cards;

import org.junit.jupiter.api.Test;
import Cards.Deck;


import static org.junit.jupiter.api.Assertions.*;

class TestDeck {

    @Test
    void isEmpty() {
        final Deck deck = new Deck();
        assertFalse(deck.isEmpty());

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

