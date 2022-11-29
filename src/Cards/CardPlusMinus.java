package Cards;

import Round.Round;

public class CardPlusMinus extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardPlusMinus uniqueInstance = new CardPlusMinus();
    private CardPlusMinus() {}
    public static CardPlusMinus getInstance(){
        return uniqueInstance;
    }

    public void playTurn() {
        Round.playPlusMinusCard();
    }

    public String getCardName(){
        return "Card Plus/Minus";
    }

    public int getBonus(){
        return 0;
    }
}

