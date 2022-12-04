package Test.Gamestate;

import Cards.CardCloverleaf;
import Gamestate.Displayer;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TestDisplayer extends Displayer{

    @Test
    void displayDice() {
    }

    @Test
    void displayScores() {
    }

    @Test
    void displayCard() {

        final Displayer disp = new Displayer();
        final CardCloverleaf clover = CardCloverleaf.getInstance();
        assertEquals(clover.getGraphicalRepresentation(), disp.messageCard(clover));
    }

    @Test
    void TestDisplayWelcomeScreen() {
        final Displayer disp = new Displayer();

        final String answer = ANSI_BLUE+ """
            ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗     ████████╗██╗   ██╗████████╗████████╗ ██████╗
            ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗    ╚══██╔══╝██║   ██║╚══██╔══╝╚══██╔══╝██╔═══██╗
            ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║       ██║   ██║   ██║   ██║      ██║   ██║   ██║
            ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝       ██║   ╚██████╔╝   ██║      ██║   ╚██████╔╝
             ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝        ╚═╝    ╚═════╝    ╚═╝      ╚═╝    ╚═════╝""";
        assertEquals(answer, disp.messageWelcomeScreen());
    }

    @Test
    void displayWinnerScreen() {
        final Displayer disp = new Displayer();

        final String answer = GREEN_BOLD_BRIGHT +"""
            ██╗    ██╗███████╗    ██╗  ██╗ █████╗ ██╗   ██╗███████╗     █████╗     ██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ ██╗██╗
            ██║    ██║██╔════╝    ██║  ██║██╔══██╗██║   ██║██╔════╝    ██╔══██╗    ██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗██║██║
            ██║ █╗ ██║█████╗      ███████║███████║██║   ██║█████╗      ███████║    ██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝██║██║
            ██║███╗██║██╔══╝      ██╔══██║██╔══██║╚██╗ ██╔╝██╔══╝      ██╔══██║    ██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗╚═╝╚═╝
            ╚███╔███╔╝███████╗    ██║  ██║██║  ██║ ╚████╔╝ ███████╗    ██║  ██║    ╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║██╗██╗
             ╚══╝╚══╝ ╚══════╝    ╚═╝  ╚═╝╚═╝  ╚═╝  ╚═══╝  ╚══════╝    ╚═╝  ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝"""+ ANSI_RESET;
        assertEquals(answer, disp.messageWin());
    }
}