package Test.Cards;

import Cards.AbstractCard;
import Cards.CardPlusMinus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardPlusMinus {



    static public AbstractCard cardA = CardPlusMinus.getInstance();
    static public AbstractCard cardB = CardPlusMinus.getInstance();

    @Test
    public void TestGetInstanceEqual() {
        assertSame(cardA, cardB);
    }

    @Test
    public void TestGetCardBonus(){
        assertEquals(cardA.getBonus(), 0);
    }


}