package Test.Cards;

import Cards.AbstractCard;
import Cards.CardCloverleaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCardCloverleaf {


    static public AbstractCard cardA = CardCloverleaf.getInstance();
    static public AbstractCard cardB = CardCloverleaf.getInstance();

    @Test
    public void getInstanceEqual() {
        assertSame(cardA, cardB);
    }

    @Test
    public void getCardBonus(){
        assertEquals(cardA.getBonus(), 0);
    }

}