package Cards;
import Round.Round;

public class CardCloverleaf extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardCloverleaf uniqueInstance = new CardCloverleaf();
    private CardCloverleaf() {
        this.cardName = "Card Cloverleaf";
    }
    public static CardCloverleaf getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playCloverLeafCard();
    }

    @Override
    public int getBonus(){
        return 0;
    }

    @Override
    public String getDescription() {
        return """
                You have to try to accomplish a “TUTTO” twice in a row on this turn
                and may not stop before you do. If you roll a null, you don’t score any points. But
                if you succeed, the game ends immediately, and you win – no matter what score
                you have!\s
                """;
    }

    @Override
    public String getGraphicalRepresentation() {
        return null;
    }
}
