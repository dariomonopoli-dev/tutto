package Cards;
import Round.Round;

public class CardCloverleaf extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardCloverleaf uniqueInstance = new CardCloverleaf();
    private CardCloverleaf() {}
    public static CardCloverleaf getInstance(){
        return uniqueInstance;
    }

    public final String cardName = "Card Cloverleaf";

    @Override
    public void playRound() {
        Round.playCloverLeafCard();}
}
