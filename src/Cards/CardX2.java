package Cards;

import Round.Round;

public class CardX2 extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardX2 uniqueInstance = new CardX2();
    private CardX2() {}
    public static CardX2 getInstance(){
        return uniqueInstance;
    }

    public final String cardName = "Card x2";

    @Override
    public void playRound() {Round.playX2Card();}
    }

