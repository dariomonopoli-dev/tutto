package Cards;

import Gamestate.Displayer;
import Round.Round;

public class CardStop extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardStop uniqueInstance = new CardStop();
    private CardStop() {
        this.cardName = "Card Stop";
        this.cardDescription = "Tough luck! You have to end your turn, and your left neighbour has his turn.";
        this.cardGraphicalRepresentation = Displayer.ANSI_RED + """                
                                  ╔══════════╗
                                  ║          ║
                                  ║          ║  Tough luck! You have to end your turn, and your left neighbour has his turn.
                                  ║   STOP   ║
                                  ║          ║
                                  ║          ║
                                  ╚══════════╝
                                """ + Displayer.ANSI_RESET;
        this.cardBonus = 0;
    }
    public static CardStop getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playStopCard();
    }
}