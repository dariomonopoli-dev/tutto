package Cards;

import Round.Round;

public class CardFireworks extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardFireworks uniqueInstance = new CardFireworks();
    private CardFireworks() {}
    public static CardFireworks getInstance(){
        return uniqueInstance;
    }

    private final String cardName = "Card Fireworks";

    public void playRound() {
        Round.playFireWorkCard();
    }

    public String getCardName(){
        return cardName;
    }

    public int getBonus(){
        return 0;
    }
}
