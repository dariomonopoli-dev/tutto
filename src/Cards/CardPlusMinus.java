package Cards;

import Round.Round;

public class CardPlusMinus extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardPlusMinus uniqueInstance = new CardPlusMinus();
    private CardPlusMinus() {}
    public static CardPlusMinus getInstance(){
        return uniqueInstance;
    }

    private final String cardName = "Card Plus/Minus";

    public void playRound() {
        Round.playPlusMinusCard();
    }

    public String getCardName(){
        return cardName;
    }

    public int getBonus(){
        return 0;
    }
}

