package Cards;

public abstract class AbstractCard {
    private String cardName;
    public String getCardName(){return this.cardName;}

    public abstract void playRound();
}
