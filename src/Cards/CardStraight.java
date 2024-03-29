package Cards;

import Gamestate.Displayer;
import Round.Round;

public class CardStraight extends AbstractCard {

        // Singleton, only one Instance of card is needed
        private static final CardStraight uniqueInstance = new CardStraight();
        private CardStraight() {
                this.cardGraphicalRepresentation = Displayer.ANSI_PURPLE + """                
                                  ╔══════════╗  Attention! This card changes the rules for valid dice. You have to try to
                                  ║          ║  accomplish a “Straight” and may not stop before you do. A “Straight” consists of all
                                  ║          ║  six numbers. As usual, you have to keep at least one valid die
                                  ║ STRAIGHT ║  after each roll. In this case, a valid die is a die that shows a number that you have not
                                  ║          ║  yet put aside. If the roll doesn’t contain any valid die, it counts as a null and you don’t
                                  ║          ║  score any points. But if you accomplish a “Straight”, you score 2,000 points for it. A
                                  ╚══════════╝  “Straight” is considered a “TUTTO” – consequently, you may continue if you want.
                                """ + Displayer.ANSI_RESET;
                this.cardBonus = 0;
        }
        public static CardStraight getInstance() {return uniqueInstance;}

        @Override
        public void playTurn() {
                Round.playStraightCard();
        }
}

