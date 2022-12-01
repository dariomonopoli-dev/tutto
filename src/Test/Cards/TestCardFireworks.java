package Test.Cards;

import Cards.AbstractCard;
import Cards.CardCloverleaf;
import Cards.CardFireworks;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardFireworks {



    static public AbstractCard cardA = CardFireworks.getInstance();
    static public AbstractCard cardB = CardFireworks.getInstance();

    @Test
    public void getInstanceEqual() {
        assertSame(cardA, cardB);
    }

    @Test
    public void getCardBonus(){
        assertEquals(cardA.getBonus(), 0);
    }

    @Test
    public void getCardName(){
        assertEquals(cardA.getCardName(), "Card Fireworks");

    }
}