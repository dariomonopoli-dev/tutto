package Test.Cards;

import Cards.AbstractCard;
import Cards.CardFireworks;
import Cards.CardStop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardStop {



    static public AbstractCard cardA = CardStop.getInstance();
    static public AbstractCard cardB = CardStop.getInstance();

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
        assertEquals(cardA.getCardName(), "Card Stop");

    }
}