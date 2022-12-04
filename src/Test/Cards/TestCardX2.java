package Test.Cards;

import Cards.AbstractCard;
import Cards.CardX2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardX2 {


    static public AbstractCard cardA = CardX2.getInstance();
    static public AbstractCard cardB = CardX2.getInstance();

    @Test
    public void getInstanceEqual() {
        assertSame(cardA, cardB);
    }

    @Test
    public void getCardBonus(){
        assertEquals(cardA.getBonus(), 0);
    }

}