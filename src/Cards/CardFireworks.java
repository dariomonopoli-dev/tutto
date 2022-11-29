package Cards;

import Round.Round;

public class CardFireworks extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardFireworks uniqueInstance = new CardFireworks();
    private CardFireworks() {
        this.cardName = "Card Fireworks";
        this.cardDescription = """
                You have to keep throwing the dice until you roll a null. After each roll,
                you need to keep all valid single dice and triplets. If you accomplish a “TUTTO”,
                you have to continue without revealing a new card. Your turn ends only when you
                roll a null. However, you score all points you have rolled on this turn.""";
        this.cardGraphicalRepresentation = """                
                                  ╔══════════╗ 
                                  ║          ║ 
                                  ║   FIRE   ║ 
                                  ║   WORKS  ║ 
                                  ║          ║ 
                                  ║          ║ 
                                  ╚══════════╝ 
                                """;
        this.cardBonus = 0;
    }
    public static CardFireworks getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playFireWorkCard();
    }
}
