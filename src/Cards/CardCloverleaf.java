package Cards;

import Helpers.DiceRoller;

public class CardCloverleaf extends AbstractCard {
    private static CardCloverleaf uniqueInstance = new CardCloverleaf();
    @Override
    public void playRound() {

    }

    public static CardCloverleaf getInstance() {
        return uniqueInstance;
    }

    // how declare instant win?
}
