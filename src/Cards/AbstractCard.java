package Cards;

public abstract class AbstractCard {

    public abstract String getCardName();

    public abstract void playTurn();
    public abstract int getBonus();
    public abstract String getDescription();
    public abstract String getGraphicalRepresentation();
}
