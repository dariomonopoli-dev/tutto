package Test.Round;

import Cards.CardStop;
import Cards.Deck;
import Player.Player;
import Round.Round;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestRound {
    @Test
    void TestSetHighestScoringPlayer() {
        Player player1 = new Player("Philipp");
        Player player2 = new Player("Johnny");
        player2.increasePlayerScore(1000);
        ArrayList<Player>  allPlayers = new ArrayList<>();
        allPlayers.add(0, player1);
        allPlayers.add(1, player2);
        ArrayList<Player>  highestScoring = new ArrayList<>();
        highestScoring.add(0, player2);
        assertEquals(highestScoring, Round.setHighestScoringPlayer(allPlayers));
    }

//    @Test
//    void TestPlayRound() {
//        final Player player1 = new Player("Philipp");
//        final Player player2 = new Player("Chris");
//        final List<Player> players = new ArrayList<>();
//        players.add(0, player1);
//        players.add(1, player2);
//        Round.playRound(players, new Deck());
//    }

    @Test
    void TestPlayStopCard() {
        String userInput = "R\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(testIn);
        Deck deck = new Deck(CardStop.getInstance());
        final Player player1 = new Player("Straff Wager");
        final List<Player> players = Arrays.asList(player1);
        Round.playRound(players, deck);
        assertEquals(0, player1.getPlayerScore());

    }

}