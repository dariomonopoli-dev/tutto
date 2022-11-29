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
    @Override
    public void playTurn() {
        Round.playBonusCard(cardBonus);}

    @Override
    public String getCardName() {
        return cardName;
    }

    @Override
    public int getBonus(){
        return cardBonus;
    }

    @Override
    public String getDescription() {
        return "If you accomplish a “TUTTO”, you get the bonus points indicated on " +
                "the card in addition to the points you have rolled. If you stop and have not " +
                "accomplished a “TUTTO”, you score only the points rolled without getting the " +
                "bonus.";
    }

    @Override
    public String getGraphicalRepresentation() {
        return null;
    }


}

