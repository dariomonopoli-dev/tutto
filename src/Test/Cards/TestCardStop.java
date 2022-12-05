package Test.Cards;

import Cards.AbstractCard;
import Cards.CardStop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardStop {



    static public AbstractCard cardA = CardStop.getInstance();
    static public AbstractCard cardB = CardStop.getInstance();

    @Test
    public void TestGetInstanceEqual() {
        assertSame(cardA, cardB);
    }

    @Test
    public void TestGetCardBonus(){
        assertEquals(cardA.getBonus(), 0);
    }

}