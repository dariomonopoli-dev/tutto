package Cards;
import Round.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardBonus extends AbstractCard {

    // Flyweight private constructor
    private CardBonus(int bonus) {

        this.cardBonus = bonus;
        this.cardName = "Bonus Card " + bonus;
    }
    final private int cardBonus;
    final private String cardName;
    final static Map<Integer, CardBonus> bonusCards = new HashMap<>();
    //Flyweight Factory
    static {
        ArrayList<Integer> allPossibleBonus = new ArrayList<>();
        allPossibleBonus.add(200);
        allPossibleBonus.add(300);
        allPossibleBonus.add(400);
        allPossibleBonus.add(500);
        allPossibleBonus.add(600);
        for (int bonus : allPossibleBonus){
            bonusCards.put(bonus, new CardBonus(bonus));
        }
    }

    //Flyweight access method
    public static CardBonus getInstance(Integer bonus) {
        return bonusCards.get(bonus);
    }

    public void playRound() {
        Round.playBonusCard(cardBonus);}

    public String getCardName() {
        return cardName;
    }

    public int getBonus(){
        return cardBonus;
    }


}

