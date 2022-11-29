package Cards;

public abstract class AbstractCard {
    String cardName;
    String cardDescription;
    String cardGraphicalRepresentation;
    int cardBonus;

    public String getCardName() {
        return this.cardName;
    }

    public String getDescription(){
        return this.cardDescription;
    }

    public String getGraphicalRepresentation(){
        return this.cardGraphicalRepresentation;
    }

    public int getBonus(){
        return this.cardBonus;
    }

    public abstract void playTurn();
}
