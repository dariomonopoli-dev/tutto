package Test.Cards;

import Cards.AbstractCard;
import Cards.CardStraight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardStraight {


    static public AbstractCard cardA = CardStraight.getInstance();
    static public AbstractCard cardB = CardStraight.getInstance();

    @Test
    public void getInstanceEqual() {
        assertSame(cardA, cardB);
    }

    @Test
    public void getCardBonus() {
        assertEquals(cardA.getBonus(), 0);
    }

}