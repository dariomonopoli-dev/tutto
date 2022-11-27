package Cards;
import Round.Round;

import java.util.ArrayList;

public class CardBonus extends AbstractCard {

    // Flyweight private constructor
    private CardBonus(int bonus) {
        this.CardBonus = bonus;
    }
    // Individual name and bonus of Instance
    private int CardBonus;
    final public String cardName = "Bonus Card" + CardBonus;
    final static private ArrayList<AbstractCard> BonusCards = new ArrayList<>();
    //Flyweight Factory
    static {
        ArrayList<Integer> allPossibleBonus = new ArrayList<Integer>();
        allPossibleBonus.add(200);
        allPossibleBonus.add(300);
        allPossibleBonus.add(400);
        allPossibleBonus.add(500);
        allPossibleBonus.add(600);
        for (int bonus : allPossibleBonus){
        BonusCards.set(bonus, new CardBonus(bonus));
        }
    }

    //Flyweight access method
    public static CardBonus getInstance(Integer bonus) {
        return (Cards.CardBonus) BonusCards.get(bonus);
    }

    @Override
    public void playRound() {
        Round.playBonusCard(CardBonus);}
    }

