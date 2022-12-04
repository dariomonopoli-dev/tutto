package Cards;

public abstract class AbstractCard {

    String cardGraphicalRepresentation;
    int cardBonus;

    public String getGraphicalRepresentation(){
        return this.cardGraphicalRepresentation;
    }

    public int getBonus(){
        return this.cardBonus;
    }

    public abstract void playTurn();
}
