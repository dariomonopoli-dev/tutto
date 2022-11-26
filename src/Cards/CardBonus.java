package Cards;
import Round.Round;

public class CardBonus extends AbstractCard {

    // Individual name and bonus of Instance
    final private String cardName = "Bonus Card";
    private int CardBonus;

    public CardBonus(int bonus) {
        CardBonus = bonus;
    }

    public int getBonus() {
        return CardBonus;
    }
    // abstract method, invoke playRound for this card type
    @Override
    public void playRound() {
        Round.playBonusCard(CardBonus);}
    }

