package Test.Gamestate;

import Gamestate.GameInitializer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestGameInitializer extends GameInitializer {

    @Test
    void TestGetPlayers() {
        final GameInitializer gI = new GameInitializer();
        gI.getPlayers();
    }

    @Test
    void TestGetWinningScore() {
        final GameInitializer gI = new GameInitializer();
        gI.getWinningScore();
    }

}