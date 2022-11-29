package Cards;

import Round.Round;

public class CardFireworks extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardFireworks uniqueInstance = new CardFireworks();
    private CardFireworks() {}
    public static CardFireworks getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playFireWorkCard();
    }

    @Override
    public String getCardName(){
        return "Card Fireworks";
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
