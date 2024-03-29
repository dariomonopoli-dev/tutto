package Cards;

import Gamestate.Displayer;
import Round.Round;

public class CardFireworks extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardFireworks uniqueInstance = new CardFireworks();
    private CardFireworks() {
        this.cardGraphicalRepresentation = Displayer.ANSI_YELLOW + """                
                                  ╔══════════╗
                                  ║          ║  You have to keep throwing the dice until you roll a null. After each roll,
                                  ║   FIRE   ║  you need to keep all valid single dice and triplets. If you accomplish a “TUTTO”,
                                  ║   WORKS  ║  you have to continue without revealing a new card. Your turn ends only when you
                                  ║          ║  roll a null. However, you score all points you have rolled on this turn.
                                  ║          ║
                                  ╚══════════╝
                                """ + Displayer.ANSI_RESET;
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
