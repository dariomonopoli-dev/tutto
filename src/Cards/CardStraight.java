package Cards;

import Round.Round;

public class CardStraight extends AbstractCard {

        // Singleton, only one Instance of card is needed
        private static final CardStraight uniqueInstance = new CardStraight();
        private CardStraight() {}
        public static CardStraight getInstance() {return uniqueInstance;}

        private final String cardName = "Card Straight";

        public void playRound() {
                Round.playStraightCard();
        }

        public String getCardName(){
                return cardName;
        }

        public int getBonus(){
                return 0;
        }
}

