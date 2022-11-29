package Cards;

import Round.Round;

public class CardStop extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardStop uniqueInstance = new CardStop();
    private CardStop() {}
    public static CardStop getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playStopCard();
    }

    @Override
    public String getCardName(){
        return "Card Stop";
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