package Cards;

import Round.Round;

public class CardStraight extends AbstractCard {

        // Singleton, only one Instance of card is needed
        private static final CardStraight uniqueInstance = new CardStraight();
        private CardStraight() {}
        public static CardStraight getInstance() {return uniqueInstance;}

        @Override
        public void playTurn() {
                Round.playStraightCard();
        }

        @Override
        public String getCardName(){
                return "Card Straight";
        }

        @Override
        public int getBonus(){
                return 0;
        }

        @Override
        public String getDescription() {
                return null;
        }

        @Override
        public String getGraphicalRepresentation() {
                return null;
        }
}

