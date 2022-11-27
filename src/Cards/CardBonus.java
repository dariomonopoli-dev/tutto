package Cards;
import Round.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardBonus extends AbstractCard {

    // Flyweight private constructor
    private CardBonus(int bonus) {
        this.CardBonus = bonus;
    }
    // Individual name and bonus of Instance
    private int CardBonus;
    final public String cardName = "Bonus Card" + CardBonus;
    final static Map<Integer, CardBonus> BonusCards = new HashMap<Integer, CardBonus>();
    //Flyweight Factory
    static {
        ArrayList<Integer> allPossibleBonus = new ArrayList<Integer>();
        allPossibleBonus.add(200);
        allPossibleBonus.add(300);
        allPossibleBonus.add(400);
        allPossibleBonus.add(500);
        allPossibleBonus.add(600);
        for (int bonus : allPossibleBonus){
            BonusCards.put(bonus, new CardBonus(bonus));
        }
    }

    //Flyweight access method
    public static CardBonus getInstance(Integer bonus) {
        return BonusCards.get(bonus);
    }

    @Override
    public void playRound() {
        Round.playBonusCard(CardBonus);}
}

