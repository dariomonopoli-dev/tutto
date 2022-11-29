package Cards;

import Round.Round;

public class CardStop extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardStop uniqueInstance = new CardStop();
    private CardStop() {
        this.cardName = "Card Stop";
    }
    public static CardStop getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playStopCard();
    }


    @Override
    public int getBonus(){
        return 0;
    }

    @Override
    public String getDescription() {
        return "Tough luck! You have to end your turn, and your left neighbour has his turn.";
    }

    @Override
    public String getGraphicalRepresentation() {
        return null;
    }
}