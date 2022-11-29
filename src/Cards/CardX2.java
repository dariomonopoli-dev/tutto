package Cards;

import Round.Round;

public class CardX2 extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardX2 uniqueInstance = new CardX2();
    private CardX2() {
        this.cardName = "Card x2";
    }
    public static CardX2 getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playX2Card();
    }


    @Override
    public int getBonus(){
        return 0;
    }

    @Override
    public String getDescription() {
        return """
                If you accomplish a “TUTTO”, all points you have rolled so far on this turn are
                doubled. If you stop and have not accomplished a “TUTTO”, you score only the
                points rolled.""";
    }

    @Override
    public String getGraphicalRepresentation() {
        return null;
    }
}

