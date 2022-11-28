package Cards;

import Round.Round;

public class CardStraight extends AbstractCard {

        // Singleton, only one Instance of card is needed
        private static final CardStraight uniqueInstance = new CardStraight();
        private CardStraight() {}
        public static CardStraight getInstance() {return uniqueInstance;}

        public void playRound() {
                Round.playStraightCard();
        }

        public String getCardName(){
                return "Card Straight";
        }

        public int getBonus(){
                return 0;
        }
}

