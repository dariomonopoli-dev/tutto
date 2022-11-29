package Cards;

import Round.Round;

public class CardX2 extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardX2 uniqueInstance = new CardX2();
    private CardX2() {}
    public static CardX2 getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playX2Card();
    }

    @Override
    public String getCardName(){
        return "Card x2";
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

