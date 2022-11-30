package Cards;

import Gamestate.Displayer;
import Round.Round;

public class CardPlusMinus extends AbstractCard {
    // Singleton, only one Instance of card is needed
    private static final CardPlusMinus uniqueInstance = new CardPlusMinus();
    private CardPlusMinus() {
        this.cardName = "Card Plus/Minus";
        this.cardDescription = """
                You must try to accomplish a “TUTTO” and may not stop before
                you do. If you roll a null, you don’t score any points. But if you succeed, you score
                exactly 1,000 points, irrespective of the number of points you have rolled. Besides
                this, the leading player has 1,000 points deducted.
                If more than one player is leading with the same number of points, each of them
                has 1,000 points deducted. Nevertheless, you, as the player who is currently rolling
                the dice, score 1,000 points only once. If it is the leading player who reveals this
                card, naturally he doesn’t have to deduct any points from his score when he
                accomplishes a “TUTTO”""";
        this.cardGraphicalRepresentation = Displayer.ANSI_PURPLE + """                
                                  ╔═════════╗
                                  ║         ║
                                  ║  PLUS/  ║
                                  ║  MINUS  ║
                                  ║         ║
                                  ║         ║
                                  ╚═════════╝
                                """ + Displayer.ANSI_RESET;
        this.cardBonus = 0;
    }
    public static CardPlusMinus getInstance(){
        return uniqueInstance;
    }

    @Override
    public void playTurn() {
        Round.playPlusMinusCard();
    }

}

