package Test.Cards;

import Cards.AbstractCard;
import Cards.CardBonus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardBonus {

    static public AbstractCard cardA = CardBonus.getInstance(500);
    static public AbstractCard cardB = CardBonus.getInstance(500);
    static public AbstractCard cardC = CardBonus.getInstance(200);

    @Test
    public void TestGetInstanceEqual() {
        assertSame(cardA, cardB);
        assertNotSame(cardA, cardC);
    }

    @Test
    public void TestGetCardBonus(){
        assertEquals(cardA.getBonus(), 500);
        assertEquals(cardC.getBonus(), 200);
        assertNotEquals(cardB.getBonus(),300);
    }
}