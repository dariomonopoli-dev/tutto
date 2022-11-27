package Cards;

import Round.Round;

public class CardStraight extends AbstractCard {

        // Singleton, only one Instance of card is needed
        private static final CardStraight uniqueInstance = new CardStraight();
        private CardStraight() {}
        public static CardStraight getInstance() {return uniqueInstance;}

        public final String cardName = "Card Straight";

        @Override
        public void playRound() {
        Round.playStraightCard();}
    }

