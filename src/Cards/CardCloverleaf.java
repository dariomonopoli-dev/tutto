package Cards;
import Round.Round;

public class CardCloverleaf extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardCloverleaf uniqueInstance = new CardCloverleaf();
    private CardCloverleaf() {}
    public static CardCloverleaf getInstance(){
        return uniqueInstance;
    }

    private final String cardName = "Card Cloverleaf";

    public void playRound() {
        Round.playCloverLeafCard();
    }

    public String getCardName(){
        return cardName;
    }

    public int getBonus(){
        return 0;
    }
}
