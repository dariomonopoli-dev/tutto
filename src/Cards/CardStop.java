package Cards;

import Round.Round;

public class CardStop extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardStop uniqueInstance = new CardStop();
    private CardStop() {}
    public static CardStop getInstance(){
        return uniqueInstance;
    }

    public void playTurn() {
        Round.playStopCard();
    }

    public String getCardName(){
        return "Card Stop";
    }

    public int getBonus(){
        return 0;
    }
}