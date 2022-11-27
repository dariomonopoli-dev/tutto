package Cards;

import Round.Round;

public class CardStop extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardStop uniqueInstance = new CardStop();
    private CardStop() {}
    public static CardStop getInstance(){
        return uniqueInstance;
    }

    public final String cardName = "Card Stop";

    @Override
    public void playRound() {
        Round.playStopCard();}
}