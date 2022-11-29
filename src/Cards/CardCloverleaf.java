package Cards;
import Round.Round;

public class CardCloverleaf extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardCloverleaf uniqueInstance = new CardCloverleaf();
    private CardCloverleaf() {}
    public static CardCloverleaf getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playCloverLeafCard();
    }

    @Override
    public String getCardName(){
        return "Card Cloverleaf";
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
