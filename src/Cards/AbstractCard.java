package Cards;

public abstract class AbstractCard {
    String cardName;
    public String getCardName() {
        return this.cardName;
    }

    public abstract void playTurn();
    public abstract int getBonus();
    public abstract String getDescription();
    public abstract String getGraphicalRepresentation();
}
