package Gamestate;


public class GameInitailizer {

    private static int getPlayerNumber(){
        // get Input and validate
        return 0;
    }

    private static String getPlayerName(){
        // get Input and validate
        return "Heiko";
    }

    public static String[] getPlayerNames() {
        int numberOfPlayers = getPlayerNumber();
        int initializedPlayers = 0;
        String[] PlayerNames = new String[numberOfPlayers];

        while(initializedPlayers < numberOfPlayers) {
            String name = getPlayerName();
            PlayerNames[initializedPlayers] = name;
            initializedPlayers++;
        }
        return PlayerNames;
    }

    public static int getMaxScore(){
        // get Input and validate
        return 0;
    }
}
