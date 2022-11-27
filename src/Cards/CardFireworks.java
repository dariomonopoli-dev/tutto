package Cards;

import Round.Round;

public class CardFireworks extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardFireworks uniqueInstance = new CardFireworks();
    private CardFireworks() {}
    public static CardFireworks getInstance(){
        return uniqueInstance;
    }

    public final String cardName = "Card Fireworks";

    @Override
    public void playRound() {
        Round.playFireWorkCard();}
}
