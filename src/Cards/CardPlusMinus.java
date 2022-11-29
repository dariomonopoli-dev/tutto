package Cards;

import Round.Round;

public class CardPlusMinus extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardPlusMinus uniqueInstance = new CardPlusMinus();
    private CardPlusMinus() {}
    public static CardPlusMinus getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playPlusMinusCard();
    }

    @Override
    public String getCardName(){
        return "Card Plus/Minus";
    }

    @Override
    public int getBonus(){
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getGraphicalRepresentation() {
        return null;
    }
}

