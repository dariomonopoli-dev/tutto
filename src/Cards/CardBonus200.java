package Cards;
import Round.Round;

public class CardBonus200 extends AbstractCard {

    // Singleton, only one Instance of card is needed
    private static final CardBonus200 uniqueInstance = new CardBonus200();
    private CardBonus200() {}

    public static CardBonus200 getInstance(){
        return uniqueInstance;
    }

    // Individual name and bonus of Instance
    final private String cardName = "Bonus Card 200";
    final public Integer bonus = 200;

    // abstract method, invoke playRound for this card type
    @Override
    public void playRound() {
        Round.playBonusCard(bonus);}
    }

