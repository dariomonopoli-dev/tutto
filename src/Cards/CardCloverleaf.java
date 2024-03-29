package Cards;
import Gamestate.Displayer;
import Round.Round;

public class CardCloverleaf extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardCloverleaf uniqueInstance = new CardCloverleaf();
    private CardCloverleaf() {
        this.cardGraphicalRepresentation = Displayer.ANSI_GREEN + """                
                                  ╔══════════╗
                                  ║          ║  You have to try to accomplish a “TUTTO” twice in a row on this turn
                                  ║  CLOVER  ║  and may not stop before you do. If you roll a null, you don’t score any points. But
                                  ║   LEAF   ║  if you succeed, the game ends immediately, and you win – no matter what score
                                  ║          ║  you have!
                                  ║          ║
                                  ╚══════════╝
                                """ + Displayer.ANSI_RESET;
        this.cardBonus = 0;
    }
    public static CardCloverleaf getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playCloverLeafCard();
    }

}
