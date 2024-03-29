package Cards;
import Gamestate.Displayer;
import Round.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardBonus extends AbstractCard {

    // Flyweight private constructor
    private CardBonus(int bonus) {

        this.cardBonus = bonus;
        this.cardGraphicalRepresentation = Displayer.ANSI_BLUE +
                """                
                                  ╔═════════╗
                                  ║         ║   If you accomplish a “TUTTO”, you get the bonus points indicated on
                                  ║  BONUS  ║   the card in addition to the points you have rolled. If you stop and have not
                                """

                +              "  ║   "+cardBonus+"   ║   accomplished a “TUTTO”, you score only the points rolled without getting the\n" +

                """               
                                  ║         ║   bonus.
                                  ║         ║
                                  ╚═════════╝
                                """ + Displayer.ANSI_RESET;
    }
    final int cardBonus;
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
    public int getBonus(){
        return this.cardBonus;
    }
}

