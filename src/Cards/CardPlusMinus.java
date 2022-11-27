package Cards;

import Round.Round;

public class CardPlusMinus extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardPlusMinus uniqueInstance = new CardPlusMinus();
    private CardPlusMinus() {}
    public static CardPlusMinus getInstance(){
        return uniqueInstance;
    }

    public final String cardName = "Card Plus/Minus";

    @Override
    public void playRound() {
        Round.playPlusMinusCard();}
}

